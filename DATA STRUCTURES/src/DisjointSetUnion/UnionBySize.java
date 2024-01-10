/*
Note: Size of a binary tree is the sum of number of nodes connected to it. 

UNION BY SIZE:
Each element initially belongs to its own set, and the size of each set is initialized to 1.

UNION BY SIZE STRATEGY:
Tree Representation: Each subset is represented as a tree, where each node corresponds to an element in the set, and the
root of the tree represents the set's representative.
Size Information: The size of a set is stored in its root node, indicating the number of elements in the set.

OPERATION:
Uniting Sets (Union Operation):
When performing a union operation, the algorithm compares the sizes of the trees representing the sets.
The root of the smaller-sized tree is made a child of the root of the larger-sized tree.
This strategy minimizes the resulting tree size and prevents the formation of skewed trees(left or right).

PURPOSE:
Balancing Tree Heights: By choosing the smaller-sized tree to merge under the larger-sized tree, the strategy helps
"balance the heights of the trees"(union by size only prevents tree from becoming too deep) in the DSU structure.

 */

package DisjointSetUnion;

import java.util.Arrays;

public class UnionBySize {

    static class DisjointSet {      // or you can name it as UnionFind
        private int[] parent;      
        private int[] size;         

        public DisjointSet(int n) {
            parent = new int[n+1];
            size = new int[n+1];          
            Arrays.fill(size, 1);       // initially size would be 1 for each set
            for(int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        // finds the ultimate parent of i (root/representative)
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }

            return parent[i] = find(parent[i]);         // Path Compression
        }

        public void unionBysize(int x, int y) {
            int rootX = find(x);    // finds root/representative of x
            int rootY = find(y);    // finds root/representative of y

            if(rootX == rootY) {        // if they both belong to the same set no need union
                return;
            }

            if(size[rootX] < size[rootY]) {
                // make y as leader of x (make rootY as representative of rootX)
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            else if(size[rootX] > size[rootY]) {
                // make x as leader of y
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else {
                // when size of i's represen. and y's represen. is same then make x as leader of y or vice versa 
                // your choice
                parent[rootY] = rootX;
                size[rootX] += size[rootY];      // update size according to your choice
            }
            
        }
    }


    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        // Note we have done one based indexing here bcz no node is 0
        ds.unionBysize(1,2);
        ds.unionBysize(2,3);
        ds.unionBysize(4,5);
        ds.unionBysize(6,7);
        ds.unionBysize(5,6);


        // if 3 ans 7 are same(belong to same set) or not
        if(ds.find(3) == ds.find(7)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        ds.unionBysize(3,7);

        if(ds.find(3) == ds.find(7)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

/*
 * NOTE:
 * TIME COMPLEXITY:
 * The time complexity will remain same as of time complexity of union by rank. i.e,
 * O(4α)   which is as good as constant time.
 * No one is going to ask you about alpha bcz it has a huge derivation.
 * 
 * SPACE COMPLEXITY:
 * O(n)
 * 
 * 
 * NOTE: 
 * WE CAN USE ANY EITHER UNION BY RANK OR UNION BY SIZE.
 * BUT I'LL USE "UNION BY SIZE" BCZ THAT IS MORE INTUITIVE TO ME.
 * 
 * 
 * UNION BY WEIGHT:
 * "Union by weight" is another way of describing the same strategy as "union by size." The term "weight" is often
 * used to represent the size of the tree or the number of elements in the subtree rooted at a particular node. So,
 * in practice, "union by weight" is essentially the same as "union by size."
 */
