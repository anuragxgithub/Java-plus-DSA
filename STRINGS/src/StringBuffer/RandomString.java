package StringBuffer;
import java.util.Random;
//Note if we follow the traditional method to generate a random string what we will do is
//keep generating the random characters and concatenate it to the ans string but this will
//create a lot of trailing objects in memory which will be just garbage.
//That is why we will use StringBuffer class since it is mutable version of string it will not
//create so many objects in heap memory. 
public class RandomString {
    static String generate(int size) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomChar = 97 + (int)(random.nextFloat() * 26);
            sb.append((char)randomChar);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        //First lets see how ranodm works
        // Random random = new Random();
        // System.out.println(random.nextFloat()); //value between 0.0 and 1.0


        System.out.println(RandomString.generate(20)); //since the method in class is static so it does
        //not depend on any object

    }
}
