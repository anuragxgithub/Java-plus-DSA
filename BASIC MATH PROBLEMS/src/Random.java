public class Random {
    public static void main(String[] args) {
        int n = 21;
        System.out.println(checkPowersOfThree(n));
    }
    static boolean checkPowersOfThree(int n) {
        if(n == 0) return true;
        // if(n==1 || n == 3) return true;
        int s = 0, e = n, m;
        while(s<=e) {
            m = s+(e-s)/2;
//            if(Math.pow(3,m) == n) return true;
            if(Math.pow(3,m) > n) {
                e = m-1;
            } else {
                s = m+1;
            }
        }
        return checkPowersOfThree(n - (int)Math.pow(3,e));
    }
}
