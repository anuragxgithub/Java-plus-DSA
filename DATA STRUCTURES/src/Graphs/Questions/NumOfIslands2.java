
/*
https://www.geeksforgeeks.org/problems/number-of-islands/1
THIS QUESTION IS NOW IN PREMIMUM SECTION OF LEETCODE AND CATEGORISED AS "HARD" PROBLEM.

QUETION: WE ARE ASKED TO RETURN THE NO. OF ISLANDS WHICH WERE PRESENT AT EACH QUERY IN A LIST.

STEPS / APPROACH :
Since here we will make dynamic connections so we can think of using DSU.
Here also we will consider each cell as a single node. Because this is the nature of DSU.
1. Consider each cell as individual node (note see the pattern in some other questions we did the same while using DSU)
   by marking them from 0 to n*m (exclusive).
   And learn how to access the node if the coordinates are given. (Easy formula: (total cols * given row) + given col
2. You will maintain a island counter var. and now whenever you get a query to add a island at specific cell you'll
   without seeing anything add the islandCounter by 1 bcz you are technically adding it.
   And now you will check its 4 neighbors whether there is island present if yes. Connect it if not already
   connected as you connect a island decrement the islandCntr by one, each time you connect two diff islands
   decrement the counter by 1.
3. Keep adding the islandCntr at each query in a list.
Also keep track of visited thing if at given query an island already exist then cnt will remain same as the 
previous query for this query too bcz no changes made. Also this visited will help us to track wether the neighbor
is island or not. 
*/


package Graphs.Questions;

import java.util.ArrayList;
import java.util.List;

public class NumOfIslands2 {
    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        // finds the ultimate parent/root of i
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);  // path compression
        }

        public void unionBySize(int rootX, int rootY) {
            if(size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                // for other two cases make rootX as root/repres. of rootY
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    static boolean isValid(int nr, int nc, int rows, int cols) {
        return nr >= 0 && nr < rows && nc >= 0 && nc < cols;
    }

    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        ArrayList<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(rows*cols);  // that many nodes will be there
        boolean[][] visited = new boolean[rows][cols];
        int cnt = 0;
        int[][] directions = new int[][] {{-1,0}, {0, -1}, {+1, 0}, {0, +1}};
        for(int[] op : operators) {
            int r = op[0];
            int c = op[1];
            if(visited[r][c]) {     // if already a island at given query then cont will remain same
                ans.add(cnt);  // don't forget to add it
                continue;
            }
            visited[r][c] = true;
            cnt++;

            for(int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];
                   
                if(isValid(nr, nc , rows, cols)) {
                    if(visited[nr][nc] == true) { // also check that neighbor cell is a island only then we go and connect them 
                        int nodeNo = (cols * r) + c;              // total cols * current row + current col
                        int adjNodeNo = (cols * nr) + nc;
                        if(ds.find(nodeNo) != ds.find(adjNodeNo)) {  // check if connection already exist or we need to connect them
                            cnt--;   // making connection so island count will decrease
                            ds.unionBySize(ds.find(nodeNo), ds.find(adjNodeNo));
                        } 
                    }   
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] operators = new int[][] {{1,3}, {0,3}, {0,1}, {1,1}, {1,0}, {1,2}, {0,3}, {1,2}};
        List<Integer> ans = numOfIslands(2, 4, operators);
        System.out.println(ans);

    }
}







