//https://youtu.be/yHwneN6zJmU
//NOTE: SEE NOTES IMPORTANT ⭐⭐

//THIS IS EUCLIDEAN ALGORITHM FOR FINDING GCD
public class GCD_EuclideanAlgo {
    public static void main(String[] args) {
        int a = 130, b = 6;
        System.out.println(gcdRecursive(a, b));  //ORDER DOES NOT MATTER a or b anyone can be bigger
        System.out.println(gcdIterative(a,b));
    }
    static int gcdRecursive(int a, int b) {
        if(b == 0) {   //base condition why b, b/z simple remain. is becoming b
            return a;
        }
        return gcdRecursive(b, a%b); //⭐⭐NOTE: YOU CAN'T CHANGE THE ORDER OF a%b if in base condition 'a' is returned then here we will do only a%b
    }
    static int gcdIterative(int a, int b){
        while(b!=0) {   // b is becoming 0 so b will be given values of rem. ahead ...simple logic.
            int rem = a%b;
            a = b;
            b = rem;
        }
        return a;
    }
}
//Euclidean algorithm to find the HCF, takes TIME COMPLEXITY OF O(log a*b) ⭐⭐
//⭐⭐NOTE: YOU CAN ALSO FIND HCF OF THREE FOUR FIVE... NUMBERS WHAT U HAVE
//TO DO IS TO MAKE A PAIR OF 2 OF GIVEN NUMBERS AND FIND THERE HCF SEPARATELY AND THEN AGAIN FIND
//HCF OF THERE HCF SIMPLE. JUST GPT IT IF U DIDN'T GET IT OPEN UR MIND.