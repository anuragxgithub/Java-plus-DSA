//FIND ALL THE PRIME NUMBERS BETWEEN 1 TO N.
//SIEVE OF ERATOSTHENES ALGORITHM
//⭐WHY THIS METHOD B/Z IF WE FIND PRIME NOS. B/W 1 TO N (range) USING (SQRT APPROACH) IT WILL TAKE
//TIME C. OF O(N*SQRT(N))
//THIS SIEVE OF ERATOSTHENES METHOD TAKES T.C. :
public class PrimeOptimised {
    public static void main(String[] args) {
        int n =  49;
        boolean[] primes = new boolean[n+1];  //by default all index have 0 i.e, (False)
        primeOrNot(n, primes);

    }
    static void primeOrNot(int n, boolean[] primes) {
        for (int i = 2; i*i <= n; i++) {
            if(!primes[i]) {   //true when i is at index where false is stored
                for (int j = i*2; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if(!primes[i]) {  //Print index where false is stored
                System.out.print(i + " ");
            }

        }
    }
}
//https://www.geeksforgeeks.org/problems/frogs-and-jumps--170647/1