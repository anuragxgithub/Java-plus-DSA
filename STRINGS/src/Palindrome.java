public class Palindrome {
    public static void main(String[] args) {
        String str = "AbcdcBa";
        System.out.println(isPalindrome(str));
        System.out.println(str);
    }

    static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) { //str == null should be placed first b/z if str.length==0 then how can be str is null
            return true; //Your choice
        }
        str = str.toLowerCase(); //New object and new variable is created
        System.out.println(str);
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
//        //Second method
//        int start = 0, end = str.length()-1;
//        while(start < end){ //or equal to
//            if(str.charAt(start) != str.charAt(end)) {
//                return false;
//            } else {
//                start++;
//                end--;
//            }
//        }
        }
        return true;
    }
}
//Third method using string builder

//StringBuilder builder = new StringBuilder();
//builder = s.reverse;
//if(builder.equals()) {
//    return true;
//        } else {
//    false;
//        }
