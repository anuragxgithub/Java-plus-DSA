public class CountEvenDigitsOptimised {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int ans = search(nums);
        System.out.println("Answer is : "+ ans);
    }
    static int search(int[] nums) {
        int count = 0;
        for (int element : nums) {
            if(evenNoOfDigits(element)) {  // evenNoOfDigits is fn to check whether no of digits is even or odd
                count++;
            }
        }
        return count;
    }
    static boolean evenNoOfDigits(int element) {
        int numberOfDigits = digits(element); // digits is fn to count no of digits
        return numberOfDigits % 2 == 0; // Return T or F depending upon condition
    }
    static int digits(int number) {
        if(number < 0) {
            number *= -1;
        }
        return (int)(Math.log10(number) + 1); // gives number of digits directly
    }
}
