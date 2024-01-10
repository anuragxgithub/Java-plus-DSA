/*
HERE EVERYTHING WILL BE SAME WE WILL PERFORM UNION BY RANK BUT WITH 
"PATH COMPRESSION" (just a slight change in find() method)

PATH COMPRESSION:
In the Union-Find data structure, path compression involves updating the pointers along the way to make future searches
faster. So, when you try to find the representative of an element, the path compression optimizes the path compression
involves "UPDATING THE PARENT POINTERS ALONG THE PATH TO POINT DIRECTLY TO THE ROOT". This way, subsequent searches take
a shorter path, making the overall operations more efficient.

The idea is to flatten the structure of the tree formed by the sets, ensuring that subsequent find operations are
more efficient.

E.g:
Let's say we have a tree like this :
1
 \
  2
   \
    3
     \
      4
       \ 
        5
So in this case : if i want to find parent of 5 then i have to travel all along from 5 to its root which will take O(logn).
But after path compression the tree will look like this:
         1 
      / | | \
     2  3 4  5
     Now if i want root of 5 ,4 , 3 or 2 in find() then it will just take constant time.

EASY PEASY...
*/

// The below implementation is of Disjoint Set Data Structure with union by rank and path compression
package DisjointSetUnion;

public class PathCompression {
    
    static class DisjointSet {      // or you can name it as UnionFind
        private int[] parent;
        private int[] rank;

        public DisjointSet(int n) {
            // 1 based indexing here bcz our nodes are not containing 0 in this example (0th idx will be ignored)
            parent = new int[n+1];
            rank = new int[n+1];          // initially rank would be 0 for each set
            for(int i = 1; i < n+1; i++) {        
                parent[i] = i;      // and we know initially each set is its own representative
            }
        }

        // finds the ultimate parent of i (root/representative)
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }

            return parent[i] = find(parent[i]);   // PATH COMPRESSION (draw recursion tree to understand.. easy)
        }

        public void unionByRank(int x, int y) {
            int rootX = find(x);    // finds root/representative of x
            int rootY = find(y);    // finds root/representative of y

            if(rootX == rootY) {        // if they both belong to the same set no need union
                return;
            }

            if(rank[rootX] < rank[rootY]) {
                // make y as leader of x
                parent[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]) {
                // make x as leader of y
                parent[rootY] = rootX;
            }
            else {
                // when rank of i's represen. and y's represen. is same then make x as leader of y or vice versa 
                // your choice
                parent[rootY] = rootX;
                rank[rootX]++;      // bcz it is where we are combining
            }
            
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        // Note we have done one based indexing here bcz no node is 0
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);


        // if 3 ans 7 are same(belong to same set) or not
        if(ds.find(3) == ds.find(7)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        ds.unionByRank(3,7);

        if(ds.find(3) == ds.find(7)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}
// https://youtu.be/aBxjDBC4M1U?si=83f2V76Zcp-ME6HR   Some clarifying words at : 20:00
/*
TIME COMPLEXITY:
So in this implementation union by rank and path compression:

Union() : O(4α) which is as good as constant time bcz (4α ~ 1) no one is going to ask you about alpha overall O(4α)
find() : O(1)

With these two optimizations, the amortized time complexity of both union and find operations becomes very close to 
constant time, which is denoted as O(α(n)), where α(n) is the inverse Ackermann function.
So our goal is now achieved now we can perform operations like merging two sets or determining whether two elements 
belong to the same set in CONSTANT TIME O(1). This is the benefit/advantage of this "DSU" Data Structure.

SPACE COMPLEXITY:
O(n)
Useful concept while dealing with graph data structure.
*/

// NOTE: THIS CODE CAN BE REUSED IN ALMOST ALL THE PROBLEMS AS IT COVERS BOTH THE "0 BASED INDEXING GRAPH AND 1 BASED
// INDEXING GRAPH".  JUST REMEMBER THIS ONLY. 

/*
--------------------------------------------------------------------------------------------------------------------
 * WHY COMBINING/ATTACHING SMALLER RANK ROOT TO LARGER RANK ROOT?
 * SIMPLE,
 * It keeps the tree structure balanced, preventing the tree from becoming too deep
 * Eg: (Let's say that we have 2 trees given below)
 
1
 \
  2
   \
    3            and     0
     \                  / 
      4                6 
       \             
        5

    Now if we attach 1 to 0 (Higher rank to lower rank) the depth/height of the tree increases which we don't want
    and if we attach 0 to 1 (Lower rank to higher rank) depth of the tree does not increases.
    
    When you attach the smaller rank tree to the larger rank tree, you are ensuring that THE OVERALL DEPTH OF THE
    RESULTING TREE DOES NOT INCREASE SIGNIFICANTLY. This helps in maintaining balance and preventing the tree from
    becoming too deep.
    But union by rank does guarantee prevention of tree from being skewed as we lost info about the height
    (as height got distorted after the path compression) of the tree (but atleast it prevented tree from becoming deep).

    SO, NOW THE QUESTION IS CAN WE ACTUALLY MANAGE/BALANCE THE HEIGHT OF TREE ???

    ANSWER IS YESS!! WE CAN, WITH THE HELP OF "UNION BY SIZE"
 */