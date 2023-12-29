package StringBuffer;
//StringBuffer is a class in java just like StringBuilder.
// A StringBuffer in Java is like a MUTABLE version of a string. It's used when you want to
//perform a lot of string manipulation operations, like concatenation, without creating a bunch 
//of new string objects. It's more memory-efficient in those cases.
public class Intro {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();  //CONSTRUCTOR 1
        System.out.println(sb.capacity());  //it has initial capacity of 16 and is dynamic can be increased when needed

        StringBuffer sb2 = new StringBuffer("Anurag Jaiswal dfhjkfsadhkfdshj");  //CONSTRUCTRO 2 (here we can initiale a string)
        System.out.println(sb2);
        System.out.println(sb2.capacity());

        StringBuffer sb3 = new StringBuffer(20);  //CONSTRUCTOR 3 (you can specify the initial size)
        System.out.println(sb3.capacity());

        //some method very few here you can explore others

        sb.append("anurag jaiswal");
        sb.insert(3,"uuu");
        // sb.delete(4,5);
        sb.deleteCharAt(0);
        sb.append(" mutableHaHa"); //see here we changed/append the sb object so it didn't created the new object rather the original object got modified and saves memory
        // sb.replace(0, 0, null)
        // sb.reverse();
        String str = sb.toString();
        System.out.println(str);
    }
}
