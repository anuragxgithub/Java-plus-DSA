/*
TELL THE NUMBER OF "DELETE" AND "INSERT" OPERATIONS REQUIRED SEPERATELY TO MAKE STRING 1 TO
STRING 2. THIS WOULD BE SIMPLE.
IF YOU OBSERVE : THAT YOU HAVE ONLY 2 OPERATIONS TO PERFORM:
1. SIMPLY FIND THE LENGTH OF THE LCS IN BOTH THE STRING.
2. COMPARE THE LENGTH OF STR1 WITH THE LCS THE DIFFERENCE WOULD BE 
   "NUMBER OF DELETE OPERATIONS"
3. COMPARE THE LENGTH OF LCS WITH STR2 DIFF WOULD BE "NUMBER OF INSERT OPERATIONS".
*/
package LCS_Classics;

public class MinDelAndIn2 {
    public static int lcs(String s1, String s2, int i, int j, Integer[][] dp) {
        if(i == s1.length() || j == s2.length()) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs(s1, s2, i+1, j+1, dp);
        }
        int op1 = lcs(s1, s2, i+1, j, dp);
        int op2 = lcs(s1, s2, i, j+1, dp);

        return dp[i][j] = Math.max(op1, op2);

    }
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "aceg";
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        int lcsLength = lcs(s1, s2, 0, 0, dp);
        int delOperations = s1.length() - lcsLength;
        int insertOperations = s2.length() - lcsLength;
        System.out.println("Num. of DEL operations required to make s1 to s2 is : " + delOperations);
        System.out.println("Num. of INSERT operations required to make s1 to s2 is : " + insertOperations);
    }
}
