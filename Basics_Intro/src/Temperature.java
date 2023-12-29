import java.util.Scanner;
public class Temperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temperature in Celcius: ");
        float temp_C = sc.nextFloat();
        float fh = (temp_C * 9/5) + 32;
        System.out.println(temp_C + " celcius into fahrenheit is " + fh);
    }
}
