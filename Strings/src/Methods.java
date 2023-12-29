import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String name = "Anuraaga";
        System.out.println(Arrays.toString(name.toCharArray())); //Also will not change actual string name as immutable new char array object ill be created
        System.out.println(name.length());
        System.out.println(name.toLowerCase()); //Here the original array name will not be modified instead new object gets created b/z immutable
        System.out.println(name); //See original one remain unchanged
        System.out.println(name.charAt(0)); //Gives the element of that index like in array arr[0]
        System.out.println("   anu rag    ".strip()); //removes all trailing and leading whitespaces
        //trim() removes a single leading white space and a single trailing white space, but does not remove multiple leading or trailing whitespaces.
        System.out.println(name.indexOf('a')); //Give index of the character which is first from beginning
        System.out.println(name.lastIndexOf('a')); //Give index of the character which is at last (index of last occurrence).
        System.out.println(name.contains("a")); //Give T or F (based on the presence or non presence of character sequence or string)
/*OR*/
        System.out.println(name.contains("raag"));
        System.out.println(name.replaceAll("An", "bb")); //regex meaning regular expression
        System.out.println(Character.isLetterOrDigit(name.charAt(0))); //Character wrapper class

        //NOTE:
        //there is lots of other str method too, also some methods which i show here has its variety too.
    }
}
