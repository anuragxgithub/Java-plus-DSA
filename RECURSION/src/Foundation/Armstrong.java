package Foundation;

public class Armstrong {

    static int isArmstrong(int num, int digits) {
        if(num == 0) {
            return 0;
        }

        int lastDigit = num%10;
        int smallAns = (int)(Math.pow(lastDigit, digits));
        return smallAns + isArmstrong(num/10, digits);

    }

    public static void main(String[] args) {
        // ArmStrong Number : 153 -> 1^3 + 5^3 + 3^3 = 153
        if(isArmstrong(154, 3) == 154) {
            System.out.println("It is a armstrong number.");
        } else {
            System.out.println("Not a armstrong number.");
        }
    }
}
