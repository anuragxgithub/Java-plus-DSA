// 2D Array list (Dynamic list of lists).

import java.util.Scanner;
import java.util.ArrayList;
public class ArrayList_2 {
    public static void main(String[] args) {
//-----------------------------------------------------------------------------------//
        ArrayList<ArrayList<String>> groceryList = new ArrayList<>();

        ArrayList<String> bakeryList = new ArrayList<>();
        bakeryList.add("pasta");
        bakeryList.add("garlic bread");
        bakeryList.add("donuts");

        ArrayList<String> produceList = new ArrayList<>();
        produceList.add("tomatoes");
        produceList.add("sauce");
        produceList.add("peppers");

        ArrayList<String> drinksList = new ArrayList<>();
        drinksList.add("chai");
        drinksList.add("beer");
        drinksList.add("coffee");

        groceryList.add(bakeryList);
        groceryList.add(produceList);
        groceryList.add(drinksList);

        System.out.println(groceryList);
//------------------------------------------------------------------------------------//
        //Input
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //Initialisation  (As like we did in 2d arrays otherwise give error)
        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<>()); // list ke andar 4 aur list ke liye jagah ban chuka hai (so neeche jab elements put karenge to vo list me jaenge)
        }
        // Adding Elements
        System.out.println("Enter the elements: ");
        for (int i = 0; i < 4; i++) {  // Rows
            for (int j = 0; j < 2; j++) { // No of cols.
                list.get(i).add(sc.nextInt());  // Get the array list at index i and add the given element to it, like in 2D arrays
            }
        }
        System.out.println(list);
    }
}
