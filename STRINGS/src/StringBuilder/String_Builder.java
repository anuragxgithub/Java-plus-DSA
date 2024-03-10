package StringBuilder;

//See Notes
public class String_Builder {
    public static void main(String[] args) {
//        <------------------------------StringBuilder Intro-------------------------------->
        StringBuilder sb = new StringBuilder("Anurag");
        System.out.println(sb);
        System.out.println(sb.charAt(0)); //char at index 0
        System.out.println(sb.reverse()); //Reverse the string
        System.out.println(sb.append(" Jaiswal")); //Add string at end
        sb.setCharAt(0,'A'); //This cannot be written with println (place char to any give index, removes the old one at that index)
        System.out.println(sb);
        System.out.println(sb.insert(0,'Z')); //Insert Character at any index
        System.out.println(sb.delete(0,1));
        System.out.println(sb.deleteCharAt(24));
        //We can use others functions of StringBuilder class as well

//        <---------------------------Program----------------------------------------------->
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a'+i);
            builder.append(ch);
            //Now here NO new objects are getting created every time instead new chr get appended
            //to it thus saving time.
        }
        System.out.println(builder);
    }
}
