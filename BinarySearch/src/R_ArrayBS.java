//NOTE: This is binary search in rotated array (DISTINCT ELEMENTS ONLY)(LEETcode 153)
// arr.length >= 1
//Can be rotated as many times
//NOTE: This is to find the minimum value in the RSA (See KILLED folder to know more)
public class R_ArrayBS {
    public static void main(String[] args) {
        int[] arr = {11,13,15,17};  //Rotated 4 times exception case b/z array remained same after rotation(i.e, in pure asc. order)
        System.out.println(findPivot(arr));
    }
    static int findPivot(int[] arr) {
        int n = arr.length;
        int start = 0, end = n-1, mid;
        while(start < end-1) {  //Remember (end -1)
            mid = start + (end-start)/2;
            if(arr[mid] > arr[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(arr[start], arr[end]);
    }
}
