public class DigitsCount {
    public static void main(String[] args) {
//      <<<<<<<<-----SEE NOTES (MANDATORY)----->>>>>>>>>
        //Digits count for binary number
        int n = 10;  //(1010 ans should be 4)
        int digitsCount = (int)(Math.log(n) / Math.log(2) + 1);
        System.out.println("The number of digits in binary will be '"+digitsCount+"'");

        //Digits count for decimal number
        int x = 23045;  //Ans should be 5
        int cDigits = (int)(Math.log10(x) + 1); //As base 10 method is already provided so we didn't use base change property
        System.out.println("The number of digits in decimal will be '"+cDigits+"'");
    }
} //This algo does not work if only 0 is provided b/z simple logic log base x of 0 is undefined (log0 is undefined)

//NOTE: There is another lengthy method to count digits while(n>0) right shift one by one and do count++.