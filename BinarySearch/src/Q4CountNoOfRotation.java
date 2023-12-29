//No of rotations is pivot index + 1.
public class Q4CountNoOfRotation {
    public static void main(String[] args) {
        int[] arr = {7,8,9,10,11,0,2,3,4}; //Rotated sorted array
        int ans = findPivot(arr);
        if(ans==-1) {
            System.out.println("Zero Rotation");
        } else {
            System.out.println("Total Numbers of Rotations are : "+(ans+1));
        }
    }
    static int findPivot(int[] arr) {
        int start = 0, end = arr.length-1;
        while(start<=end) {
            int mid = start+ (end-start)/2;
            //Remember four condition
            if(mid<end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid>start && arr[mid] < arr[mid-1])  {  //Koi bhi element apne previous element se chota nahi hoga agr hoga to piche wala element pivot hoga
                return mid-1;
            }
            if(arr[start] >= arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1; //this execute when opposite of if condition occur
            }
        }
        return -1; //0 rotation
    }
}
