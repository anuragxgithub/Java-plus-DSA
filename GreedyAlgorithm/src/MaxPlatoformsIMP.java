

// https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

import java.util.Arrays;

public class MaxPlatoformsIMP {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // find the overlapping trains (max overlapping = platforms required)
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0, j = 0;
        int count = 0;
        int ans = 0;
        
        while(i < n) {
            if(dep[j] >= arr[i]) {
                i++;
                count++;
                ans = Math.max(ans, count);
            } else if(dep[j] < arr[i]) {
                j++;
                count--;
            }
        }
        return ans;
    }
}
