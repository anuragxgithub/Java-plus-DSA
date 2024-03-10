import java.util.ArrayList;

public class In_Function {
    public static void main(String[] args) {
        int x = 12;
// ArrayList<Integer> list = new ArrayList<>(); u can also pass lise this 👇
        System.out.println(demo(x, new ArrayList<>()));
    }

    static ArrayList<Integer> demo(int x, ArrayList<Integer> list) { //Return type of function is ArrayList
        list.add(x);
        return list;
    }
}
