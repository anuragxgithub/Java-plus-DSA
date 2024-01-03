import java.util.Arrays;
import java.util.HashMap;

public class CountSort2 {
    public static void main(String[] args) {
        // Implementation using HASHMAP
        int[] arr = {6,3,10,9,2,4,9,7, 1,2,4,7,3,4,2,9,8,2};
        System.out.println("Array before sorting : " + Arrays.toString(arr));
        countSort(arr);
        System.out.println("Array after sorting : " + Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // we'll store the frequency of each element as value and element as key

        for (int item : arr) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        // now find max element from the array
        int maxItem = findMax(arr);
        int minItem = Arrays.stream(arr).min().getAsInt();
        int idx = 0;
        // now loop the hashmap from minimum to maxItem(Included) and place elements accordingly in array
        for(int i = minItem; i <= maxItem; i++) {
            int count = map.getOrDefault(i, 0);  // used to retrieve the value associated with a specified key, or a default value if the key is not present in the map.
            for(int j=0; j < count; j++) {
                arr[idx] = i;
                idx++;
            }
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}

/*
Time Complexity:
While loop is running frequency times so total frequency of each element would be equal to the size of
input array.
And outer for loop is running till maxItem.
Therefore, overall time complexity of this code is : O(maxItem + n)

Space complexity : O(number of unique elements) i.e, O(n) in worst case.
*/

// NOTE: YOU CAN USE EITHER ARRAY IMPLEMENTATION OR HASHMAP IMPLEMENTATION AS YOUR WISH.