//THIS ALGORITHM WORKS ONLY WHEN DUPLICATE ELEMENTS ARE PRESENT IN EVEN NUMBER.
//FOR ODD NUMBERS SEE FindUnique2
//'UNIQUE' HERE REFERS TO THE ELEMENT WHICH OCCUR ONLY ONCE
public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2,3,3,4,2,6,4}; //FIND ELEMENT PAIR IS NOT PRESENT (NOTE -2 ^ 2 IS ALSO 0)
        System.out.println(findUnique(arr));
    }

    static int findUnique(int[] arr) {
        int unique = 0;
        for(int n : arr) {
            unique = unique^n;
        }
        return unique;
    }
}
