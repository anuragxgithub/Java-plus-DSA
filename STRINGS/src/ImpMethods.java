//there are lots of things which we can do with string explore it according to your need.
import java.text.DecimalFormat;
import java.util.Arrays;

public class ImpMethods {
    public static void main(String[] args) {
        //Remove whitespaces
        String sentence = "hi  my name i s anurag j  aiswal";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));

        //split
        String s = "Anurag Rahul Ansh Aman";
        String[] names = s.split(" "); //split at the spaces you can split at any particular thing
        String[] anything = s.split("a"); 
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(anything));

        //decimal format  (you can check out the documentations)
        //rounding off
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(7.2));
        DecimalFormat df2 = new DecimalFormat("00.00");
        System.out.println(df2.format(7.249));
        System.out.println(df2.format(7.235));
        System.out.println(df2.format(7.245));
        

    }
}
