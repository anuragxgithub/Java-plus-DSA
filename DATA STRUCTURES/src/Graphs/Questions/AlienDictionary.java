
/*
https://www.geeksforgeeks.org/problems/alien-dictionary/1
NOTE: THIS IS IN LEETCODE PREMIUM NOW

Note: In dictionary words are present in sorted order like words start from a and end to z.
If the first letter of two words(1st and 2nd) are same then we compare the second letter 
if they are different then we can say thay second letter of 1st word comes first in alphabet
before the second letter of 2nd word
So for sorted alien dictionary {{"baa","abcd","abca","cab","cad"}}
comparing first two words we can clearly say that b comes before a.
comparing the 2nd and 3rd word which have 3 same letters so we'll compare the last different
letter which is d and a so clearly we can say that d comes before a in alien language.. and so on.

Here in question we are seeing that it is kind of dependency question(something comes before
something) so we can think of topo sort here.

So lets see how we can make a directed graph out of these words:
1. Keep comparing two words from starting and find the first different letter from the words. 
2. Point the letter of 1st word to the letter of 2nd word. (bcz the first letter comes before
any other letter, has no dependency)
3. After making the DG. Perform the Topo Sort. Here I will use Kah's algo (BFS)
*/

package Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> graph, int[] indeg, int K) {
        // calculating indegree
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < graph.get(i).size(); j++) {
                indeg[graph.get(i).get(j)]++;      // num of incoming edges
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < K; i++) {
            if(indeg[i] == 0) {
                //bcz in DAG atleast one element has indegree 0
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        //bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);         // toposort order
            
            // visite the neihbors and decrement their indegree
            for(int i = 0; i < graph.get(curr).size(); i++) {
                int neigh = graph.get(curr).get(i);
                indeg[neigh]--;
                if(indeg[neigh] == 0) {
                    q.add(neigh);
                }
            }
            
        }
        return ans;
    }
    //User function Template for Java
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N-1; i++) {
            String w1 = dict[i];
            String w2 = dict[i+1];
            int len = Math.min(w1.length(), w2.length());
            for(int j = 0; j < len; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
                    //char of word w1 will point to char of word w2
                    break;   // no need to check for other letters
                }
            }
        }
        
        int[] indeg = new int[K];
        ArrayList<Integer> topo = topoSort(graph, indeg, K);
        
        
        String ans = "";
        for(int it : topo) {
            ans += (char) (it+(int)('a'));
        }
        return ans;
        
    }    
}

/*
1 thing to note here that we are also covering the case where we are given lets say 4 words
that contains 4 type of letters so N would be 4. And..  AND..  K is given as 5
that means we have to return order of 5 letters but 5th letter is not present in given
4 words so this case also get covered because we are making the 5th word as seperate
node which obviously has no incoming edges. (bcz see we are taking indegree array of
size K so 5th letter will also be added in queue.)


Time & Space
Constructing the graph: O(N * K)
Topological Sort (BFS): O(V + E)   // E is number of edges
Time : O(N*K)

Graph representation: O(K + E)
Indegree array: O(K)    :    Queue for BFS: O(K)
Space: O(K+E)
*/

/*
NOTE: THE INTERVIEWER CAN TWEAK THE QUESTION AND CAN ASK YOU LIKE
WHEN DOES THIS ORDER IS NOT POSSIBLE : SO SAY THIS BY GIVING EXAMPLE
Case 1: If the case is like there are two words only lets say 1st one is "abcd" and 2nd one is "abc"
So in this case no matter from which language it is, the dictionary is faulty bcz "abcd" can't come before "abc".

Case2: When there is cycle like "abc", "dcm" and "amx"  Here a < d < a which is not possible.
*/