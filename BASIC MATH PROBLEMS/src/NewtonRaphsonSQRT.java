//SEE NOTES RECOMMENDED
//FOR DERIVATION OF THIS FORMULA
/*
Math.abs is basically it returns the positive value of any given number +ve or -ve.
double num = -3.14159;
double absNum = Math.abs(num); // absNum is now 3.14159
int num = -5;
int absNum = Math.abs(num); // absNum is now 5
*/
public class NewtonRaphsonSQRT {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(sqrt(n));

    }
    static double sqrt(int n) {
        double guessedRoot = n;  //you can take any value of guessed root here I took the number itself as guessed root
        double root;
        while(true) {
            root = 0.5* (guessedRoot + (n/guessedRoot));
            if (Math.abs(root - guessedRoot) < 0.001) {  //here 0.001 is Error which will come in ans u can increase or decrease accordingly but decreasing more increases time complexity.
                break;
            }
            guessedRoot = root;  //keep decreasing the guessed root.
        }
        return root;
    }
}
//TIME COMPLEXITY: O(log(n) f(n)), where f(n) is the complexity of calculating f(x)/f'(x) with some n digit precision.
//This is calculated via Fast Fourier transform algo which is an advance maths topic not asked in Interview.
//See sqrt normal file for other method.