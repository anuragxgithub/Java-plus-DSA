//QUESTION: GIVEN AN ARRAY PERFORM LINEAR SEARCH TO FIND TARGET
//CHALLENGES:
//1: ELEMENTS CAN OCCUR MANY TIMES RETURN THE INDEX OF ALL TARGET ELEM. PRESENT IN ARRAY.
//2: RETURN TYPE OF FN MUST BE ArrayList b/z there is other approach too like create a list outside of function.
//3: CREATE ARRAYLIST INSIDE THE FUNCTION ⭐⭐ (REAL CHALLENGE)
//4: CAN'T CREATE ARRAYLIST IN MAIN FN. OR OUTSIDE ANYWHERE.

//NOTE: This one is lil tough than the other(good) approach covered in 1st part of this file
//just know this approach too sometimes it is also needed.  Gives Good Grip In recursion

//Note: Since the list is created inside the function so at each call of fn (due to recursion), the new list is being created.
//That's why this approach is lil tough we have to collect all the list answers and then return it.

//See Notes To Understand The flow if u don't get it. (Under RecursionTips)
import java.util.ArrayList;
public class ReturnArrayList2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,34,5,7,2};
        int target = 2;
        System.out.println(findAllIndex(arr, target, 0));
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length) {
            return list;
        }
        if(arr[index] == target) {
            list.add(index);
        }
//        System.out.println(list);  proof that at every fn call new list is created
        ArrayList<Integer> ans = findAllIndex(arr, target, index+1);
        list.addAll(ans);     //list.addAll() is a method that is used to add all the elements from one collection, such as an ArrayList, into another collection.
                              //list.add() will not work b/z list.add() required type is integer, not a collection
        return list;
    }
}

//PREREQUISITE: adding an empty list with non-empty list gives the non-empty list itself.
//EasyPeasy
//T.C : O(n)
//S.C. : O(n) + O(n) = O(n) one is for stack call and one for lists being created.
//⭐⭐⭐ Very Important question to get strong grip on recursion flow control.
