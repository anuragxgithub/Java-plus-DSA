/*
-----------> READ THIS ONCE <-----------
The terms "disjoint set data structure" and "disjoint set union data structure" are often used interchangeably,
and they refer to the same concept. Both terms typically refer to the data structure designed to efficiently manage a
partition of a finite set into disjoint sets, and the primary operations include MakeSet, Union, and FindSet.

-------------------> SIMPLE, NORMAL DEFINITION <-------------------
Disjoint Set Union (DSU), also known as Union-Find, is a data structure that efficiently keeps track of a partition of a
set into disjoint subsets. This data structure is particularly useful in scenarios where you need to perform operations
like merging two sets or determining whether two elements belong to the same set. In almost "constant time".
"Identity of a set is usually an element of the set that acts as a representative for it".

It provides two main operations: union and find.

OPERATIONS:
1. MakeSet: This operation initializes a new set with a single element. Each element is initially its own representative
in its own subset.
2. Union (Merge): Combines two sets into a single set. This involves finding the leaders of the two sets and
making one of them the leader of the other. 
3. Find (Find Set Representative): Determines the representative (leader)/root of the set to which a particular element
belongs. This operation is often used to check whether two elements are in the same set.
The leader/representative is the root of the DSU tree. And a representative of a root/repres. is representative itself.

Applications:
-> Kruskal's algorithm for finding the minimum spanning tree of a graph.
-> Finding cycle in an undirected graph
-> Dynamic connectivity problems in computer science.
DSU is a fundamental data structure with various applications, especially in graph algorithms and problems that
involve maintaining and merging sets.
 
 */
// https://youtu.be/wU6udHRIkcc?si=ZVNuh0MJAOCxJIzB
// https://youtu.be/aBxjDBC4M1U?si=68PzUV3X1ZWDtR6o

package DisjointSetUnion;

public class DisjointSetUnion {
    static class DisjointSet {
        private int[] parent;

        public DisjointSet(int size) {      // construtor
            parent = new int[size];
            makeSets();
        }

        private void makeSets() {
            // Each element here initially represents its own set
            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;    // Each element is initially its own representative
            }
        }

        // finds in which set a particular element is belonging so here we implemented it as to find the
        // the representative (root) of the set that includes element x
        public int find(int x) {
            if(parent[x] == x) {    // when element is its own representative that means it belongs to its own set
                return x;
            }
            
            return find(parent[x]);  // Traverse up the tree until finding the root
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY) {          // means they belong to to different set
                parent[rootY] = rootX;    // Make one root the parent of the other    (this will make a new set with combined elements because now for new and old elements the root is same)
            }
        }
    }
    
        public static void main(String[] args) {
            int size = 6; // Number of elements
            DisjointSet ds = new DisjointSet(size);
    
            ds.union(1, 1);
            ds.union(1, 2);     // parent of 1 will 0 and parent of 2 will be 2 since they both have different 
                                    // root/representative then union it new set will be {0,1,2} 
            ds.union(3, 4);
    
            System.out.println(ds.find(2)); // Output: 0 (representative of the set)
            System.out.println(ds.find(4)); // Output: 3 (representative of the set)

            // (1,2) , (2,3), (4,5), (6,7), (5,6), (3,7)
            // TO UNDERSTAND THE TIME COMPLEXITY dry run this
        }
}

/*
 * Time Complexity:
 * Find()   ->  Worst-case: O(log n), where n is the number of elements in the set.
 * Union() (Depends on the time of find() ultimately) -> so : O(log(n))
 * 
 * So overall time complexity would be: O(m * log n).   , where m is the total number of union and find operations
 * 
 * SPACE COMPLEXITY:
 * O(n)
 */
// APPLICATION OF DISJOINT SET UNION DATA STRUCTURE IS IN KRUSKAL'S ALGORITHM OF FIND MST
// IT ALSO HELPS IN DETECTING CYCLES IN GRAPH and in other question also like find path if exists..


// NOTE: THIS ONE IS JUST SIMPLE/TYPICAL DISJOINT SET UNION DATA STRUCTURE IMPLEMENTATION. THIS CAN BE OPTIMISED:
// BY OPTIMISING THE UNION OPERATION(like using union by rank) and BY OPTIMISING THE FIND OPERATION(using path compression)
// So that our goal is reached to make operations work in "constant time".

// IMPORTANT FOR INTERVIEWS IN CONTEXT TO GRAPHS.