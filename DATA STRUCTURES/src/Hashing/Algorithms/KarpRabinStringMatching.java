// https://www.geeksforgeeks.org/problems/search-pattern-rabin-karp-algorithm--141631/1  ⭐

package Hashing.Algorithms;
/*
The Rabin-Karp algorithm is a string searching algorithm that efficiently finds the occurrence 
of a pattern within a text. It's based on "hashing" or "hash values" and is particularly useful when you need to 
find multiple occurrences of a pattern in a large text.
" Well-suited for pattern matching in large texts."
*/

public class KarpRabinStringMatching {
    class RabinKarp {
        private final int  PRIME = 101;       // you can choose any prime number
        
        private double calculateHashCode(String str) {
            double hash = 0;
            for(int i = 0; i < str.length(); i++) {
                hash += str.charAt(i) * Math.pow(PRIME, i);   // i -> representing idx of each char we are considering for each window 
            }
            return hash;
        }

        private double updateHashCode(double prevHash, char oldChar, char newChar, int patternLength) {
            // this is needed when we move ahead one char and create new window to match and
            // this should be done in constant time (This can be considered as rolling hash technique)
            double newHash = (prevHash-oldChar) / PRIME;
            newHash += newChar * Math.pow(PRIME, patternLength-1);   // prime no is given a power which is last equal to last idx as new char added in new window is from last 
            return newHash;
        }

        public void search(String text, String pattern) {
            // 'text' is what is given and 'pattern' is what we need to find from text
            int patternLength = pattern.length();
            double patternHash = calculateHashCode(pattern);
            double windowHash = calculateHashCode(text.substring(0, patternLength));

            // Now check whether current window hash is matching to pattern hash
            for(int i = 0; i < text.length() - patternLength+1; i++) {   // if (i < text.length() - patternLength+1) and if i exceeds this length then obviouly pattern can't be found in a substring which is smaller than the pattern itself
                if(patternHash == windowHash) {
                    // confirm it that wheter actually it is equal or not bz it may be possible that two words will have same hashCode but very less probability
                    if(text.substring(i, i+patternLength).equals(pattern)) {
                        System.out.println("Pattern found at index : " + i); 
                    }
                }
                if(i < text.length() - patternLength) {
                    windowHash = updateHashCode(windowHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
                }

            }
        }
    }
    
    public static void main(String[] args) {
        // // Que) find where string a is substring of string b?
        // String a = "Anurag";            //lets say size is m
        // String b = "RahulAmanAnuraglolo";   // size is n
        // int counter = 0;

        // int m = a.length();
        // int n = b.length();

        //⭐1. Naive approach which takes quadratic time complexity O(m*m) or O(n*m)  ..No need to go into this much

        // for(int i = 0; i < n-m+1; i++) {        // approx m times 
        //     for(int j = i; j < i+m; j++) {      // in worst case going m times 
        //         if(b.charAt(j) == a.charAt(j-i)) {
        //             counter++;
        //         } else {
        //             break;
        //         }
        //     }

        //     if(counter == m) {
        //         System.out.println("Yes string 'a' is substring of string 'b'.");
        //         break;
        //     } else {
        //         counter = 0;
        //     }
        // }
        // if(counter == 0) {
        //     System.out.println("String 'a' is not substring of string 'b'.");
        // }

        //⭐2. Using substring method     O(n)
        // for(int i = 0; i < n-m; i++) {
        //     if(a.equals(b.substring(i, i+m))) {
        //         counter++;
        //         System.out.println("True");
        //         break;
        //     }
        // }
        // if(counter == 0) {
        //     System.out.println("False");    
        // }

        //⭐3. USING RABIN-CARP ALGORITHM  (String matching in Linear Time)
        
        /* 
         'a' * 5 = 97*5 = 458  know this.
         >>> IDEA OF THE PROGRAM WRITTEN BELOW <<<
         As we know KarpRabin algo is based on hashing. So
         What we do is first we'll create hashCode of pattern/target string and then we will keep creating a window of
         size patternLength (pretty obvious) from the text we are given with and we will keep matching the hashCode of
         window and pattern. And if it is matched then we'll confirm that whether the strings actually matching or not
         bcz it may be possible that hashcode of two words are same but the probability is less(see Universal Hashing 
         section from kunal's video of hashing to understand what will be the prob. of happening this). So if hashCode
         of pattern match or not we will create new window by just sliding one char ahead which is again pretty logical
         and then we will get new hash for this window from updateHash() method and again check wheter this part window
         is equal to pattern or not Simple.
         https://chat.openai.com/share/b71fb3ce-047c-4aa1-a952-f69d9efce87a
        */

        KarpRabinStringMatching x = new KarpRabinStringMatching();  // (you can make the class static to remove this line)

        RabinKarp algorithm = x.new RabinKarp();
        algorithm.search("ShivaAmanAnuragLolo", "Anurag");
        
    }

    /*
    Time Complexity Analysis:
    The time complexity of the Rabin-Karp algorithm is generally considered to be O((n + m) * hash computation time), where:
        n is the length of the text,
        m is the length of the pattern,
        "hash computation time" is the time it takes to compute the hash function.

    Combining these complexities, we get O(m) + O((n - m + 1) * m), and considering the dominant term,
    the time complexity of your Rabin-Karp algorithm is O((n - m + 1) * m).
    */
    // NOTE: IN THE WORST CASE IT CAN GET QUADRATIC TIME COMPLEXITY O(m*n), especially if hash collisions occur
    // frequently. So you can use multiple hash function in that case: you can checkout Monte Carlo Variant but it 
    // is very high level no one gonna ask it in interviews.

    // IN THE ABOVE CODE OF RABIN CARP ALGORITHM WE HAVE USED "The Las Vegas Variant". which you can google.
}
