/*
 In Union by rank, each set (or tree) is associated with a rank or depth.
 Here we find out union according to the rank of each subsets.
 -> When performing a union operation, the tree/set with the smaller rank is merged into the tree/set with the larger
    rank. And if rank is same for both the sets you can merge according to your choice.
 -> The rank of a set is initially set to 0, and it is updated during the union operation based on the current ranks of
    the sets being merged.
 -> Union by rank helps to keep the tree structure balanced, preventing the tree from becoming too deep.

 BASICALLY OPTIMISATION TECHNIQUE OF DISJOINT SET DATA STRUCTURE

 EASY PEASY...
 https://youtu.be/aBxjDBC4M1U?si=83f2V76Zcp-ME6HR
*/


package DisjointSetUnion;

public class UnionByRank {
    static class DisjointSet {      // or you can name it as UnionFind
        private int[] parent;       //NOTE: WE CAN ALSO USE ARRAYLIST HERE TOO BUT THT IS NOT REQUIRED
        private int[] rank;         

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];          // initially rank would be 0 for each set
            for(int i = 0; i < parent.length; i++) {        
                parent[i] = i;      // and we know initially each set is its own representative
            }
        }

        // finds the ultimate parent of i (root/representative)
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }

            return find(parent[i]);         // Traverse up the tree until finding the root 
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
        int size = 6;
        DisjointSet ds = new DisjointSet(size);

        ds.unionByRank(0,1);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);

        /*
                0                       
            /   |   \
           1    2    3

           4
           |
           5
        */

        System.out.println(ds.find(3));     // representative of 3 will be 0
        System.out.println(ds.find(4));     // representative of 4 will be 4
        System.out.println(ds.find(5));     // representative of 5 will be 4
    }
}

/*
 * TIME COMPLEXITY:
 * 1. Find():
 * Amortized Time Complexity: O(log n) due to path compression. In each call to find, the path from the element to its
 * representative is shortened. (Here path compression, just only because length of overall tree will be short)
 * 2. Union():
 * Amortized Time Complexity: O(log n) due to union by rank. The height of the tree is kept small, and the shorter
 * tree is attached to the root of the taller tree.
 * 
 * The amortized analysis considers the overall cost of a sequence of operations, and the amortized time complexity
 * per operation remains low. Therefore, for a sequence of m Union-Find operations on a set of n elements, 
 * the OVERALL TIME COMPLEXITY is O(m * α(n)), where α(n) is the inverse Ackermann function, and it grows extremely slowly.
 * and m is the total number of union and find operations.
 * 
 * SPACE COMPLEXITY:
 * O(n)
 */

// But still we are unable to do it in constant time !!!
// So now we'll do actual path compression in next file.