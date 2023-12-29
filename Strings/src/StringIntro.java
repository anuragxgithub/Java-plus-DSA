public class StringIntro {
// <----EVERYTHING IS EXPLAINED IN NOTES VERY WELL----->
    public static void main(String[] args) {
        //String Declaration and initialisation---->
        String name = "Anurag";
        System.out.println(name);
        //Strings Comparison------>
        String a = "Shiv";
        String b = "Shiv";
        System.out.println(a == b); //If gives true that means both a and b are pointing to single object in memory
        System.out.println(a.equals(b)); //Gives true when values are same nothing to do with pointing of variables.

        String x = "Aman";
        String y = new String("Aman"); //Explicitly telling to create separate object with same value of string in memory
        System.out.println(x==y); //Gives false b/z ref. vars. are pointing to different objects in heap (doesn't matter whether same object or not)
        System.out.println(x.equals(y)); //Obviously give true b/z same value

        //String Immutability------>
        String name1 = "Aman";
        String name2 = name1;
        System.out.println(name1);
        System.out.println(name2);
        name2 = "Rohit";
        System.out.println(name1); //Name1 will remain same no changes thats why immutable
        System.out.println(name2); //Name2 now will point to new object.
        /*
        If you do the same thing with array changes will made for both variables
        b/z arrays are mutable.
        */
    }
}