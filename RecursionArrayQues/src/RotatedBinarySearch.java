//Return Index Of Target.
//NOTE: PAY ATTENTION WHILE COMPARING ALMOST AT EVERY PLACE WE ARE USING >= OR <= IF
//WE USE ONLY > OR < THEN ANS WILL COME OUT WRONG AND WHY WE ARE DOING IT IS PRETTY LOGICAL
public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {9,1,2,3,4,5,6,7,8};
        int target = 9;
        int start = 0, end = arr.length-1;
        System.out.println(rbs(arr, target, start, end));
    }

    static int rbs(int[] arr, int target, int start, int end) {
        if(start>end) { //base condition (StopCondition)
            return -1;
        }
        int mid = start+(end-start)/2;
        if(arr[mid] == target) {
            return mid;
        }

        if(arr[mid] >= arr[start]) {
            if(target >= arr[start] && target<arr[mid]) {
                return rbs(arr,target, start, mid-1);
            } else {
                return rbs(arr,target,mid+1, end);
            }
        }
        //If we came hare that means we(mid var.) are in second half of array
        if(target>arr[mid] && target <= arr[end]) {
            return rbs(arr,target,mid+1,end);
        } else {
            return rbs(arr, target, start, mid - 1);
        }
    }
}
