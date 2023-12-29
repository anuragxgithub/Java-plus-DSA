public class SkipCharacter {
    public static void main(String[] args) {
        String name = "AnauarAga";
//        String x = name.replaceAll("a","");  //one of the method
//        correctName(name, 0, "");         //for method 1
//        remove(name, "");                 //for method 2
          System.out.println(skip(name));     //for method 3
    }

    //METHOD 1: BY TAKING ANOTHER ANS. STRING IN ARGUMENT

//    static void correctName(String name, int index, String ans) {
//        if(index == name.length()) {  //base case
//            System.out.println(ans);
//            return;
//        }
//        if(name.charAt(index) == 'a') {
//            correctName(name, index+1, ans);
//        } else {
//            ans = ans+name.charAt(index);
//            correctName(name, index+1, ans);
//        }

    //METHOD 2: BY USING SUBSTRING METHOD (Good)

//        static void remove(String name, String ans)  {
//        if(name.isEmpty())  {
//            System.out.println(ans);
//            return;
//        }
//        char ch = name.charAt(0);
//        if(ch == 'a') {
//            remove(name.substring(1), ans);   //Gives new String from index 1 to name.length
//        } else {
//            remove(name.substring(1), ans+ch);
//        }

    //METHOD 3: RETURN TYPE IS STRING  (Better)

        static String skip(String name) {
            if(name.isEmpty()) {
                return "";
            }
            char ch = name.charAt(0);
            if(ch == 'a') {
                return skip(name.substring(1));   //Gives new String from index 1 to name.length
            } else {
                return ch + skip(name.substring(1));
            }
    }
}