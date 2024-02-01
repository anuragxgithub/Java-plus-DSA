
/*

https://leetcode.com/problems/accounts-merge/ 

*/


package Graphs.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    static class DisjointSet {
        int[] parent;
        int[] size;
        
        public DisjointSet(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        // finds the root of i
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }
        
        public void unionBySize(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootX != rootY) {
                if(size[rootY] > size[rootX]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    // in other two cases
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {    // taking mails only not name obviously
                String s = accounts.get(i).get(j);
                if(mapMailNode.containsKey(s)) {
                    ds.unionBySize(mapMailNode.get(s), i);  // merge them
                } else {
                    mapMailNode.put(s, i);
                }
            }
        }
        @SuppressWarnings("unchecked")
        ArrayList<String>[] mergedMails = new ArrayList[n];
        for(int i = 0; i < n; i++) mergedMails[i] = new ArrayList<>();
        
        // Take all mails from map and add it to their account holder
        for(Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.find(it.getValue());  // find ultimate parent of the mail holder
            mergedMails[node].add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(mergedMails[i].size() == 0) continue;
            Collections.sort(mergedMails[i]);   // sorting the mails
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));    // first adding name
            for(String it : mergedMails[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}
/*
Time Complexity : O(n * m * log n)           taking logn for finding root
Space Complexity : O(n * m)
*/