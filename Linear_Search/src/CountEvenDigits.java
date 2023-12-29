// LeetCode question 1295. (Solved it in first attempt)

public class CountEvenDigits {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int ans = search(nums);
        System.out.println("Answer is : "+ ans);
    }
    static int search(int[] nums) {
        int digits = 0, countEvenDigits=0;
        //if element is negative
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        //if element = 0
            if (nums[i] == 0) {
                digits = 1;
            }
        //counting number of digits
            while(nums[i] > 0) {  // OR To count the number of digits of any number u can convert it to string and then str.length()
                nums[i] = nums[i] / 10;
                digits++;
            }
        //checking whether digit count is even
            if(digits % 2 ==0) {
                countEvenDigits++;
            }
            digits = 0; // now again making the digits 0 to start count for other elements
        }
        return countEvenDigits;
    }
}

//---------------------2nd Method (Good practice may be)--------------------------//

//public class CountEvenDigits {
//    public static void main(String[] args) {
//        int[] nums = {12, 345, 2, 6, 0,-223, 7896,1,23};
//        int ans = search(nums);
//        System.out.println("Answer is: "+ans);
//    }
//    static int search(int[] nums) {
//        int count = 0;
//        for(int element : nums) {
//            if(evenNoOfDigits(element)) { // another fn to find whether the digits count is even or odd
//                count++;
//            }
//        }
//        return count;
//    }
//    static boolean evenNoOfDigits(int element) {
//        int numberOfDigits = digits(element); //another fn to find the digits count
//        /* if(numberOfdigits % 2 == 0) {
//            return true;
//        } else {
//            return false;
//        } */  //shorter version of this:
//        return numberOfDigits % 2 == 0;
//    }
//    static int digits(int number) {
//        int dCount = 0;
//        if(number == 0) {
//            return 1;
//        }
//        if(number < 0) {
//            number *= -1;
//        }
//        while(number>0) {
//            dCount++;
//            number /= 10;
//        }
//        return dCount;
//    }
//}