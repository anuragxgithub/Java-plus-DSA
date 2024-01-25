

/*
https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

We have to return the smallest number of citites we can go, from any specifc city using at most threshold distance. But But if there are multiple such citites (eg city 1 and city 2 both can go to any one specific city then in this case we have multiple choice) so we'll return the the city with 
greater number labelled in above eg ans would be city 2.
*/

package Graphs.ShortestPathAlgos;

public class FWque2 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // making a distance matrix for floyd warshall algo
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j<n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < edges.length; i++) {  // remember edges.length
            int row = edges[i][0];
            int col = edges[i][1];
            int wt = edges[i][2];
            dist[row][col] = wt;
            dist[col][row] = wt;  // since bi-directional
        }
        for(int i = 0; i < n; i++) dist[i][i] = 0;

        // Floyad Warshall Algo
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int countCity = n;
        int cityNo = -1;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j = 0; j<n; j++) {
                if(dist[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if(count <= countCity) {
                countCity = count;
                cityNo = i;
            }
        }

        return cityNo;
    }
}
/*
Time : O(n^3)
Space Complexity : O(n^2)
*/
// NOTE WE CAN ALSO USE DIJKSTRA'S ALGO JUST FIND OUT SHORTEST PATHS FOR EACH NODE.