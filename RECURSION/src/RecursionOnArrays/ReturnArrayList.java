package RecursionOnArrays;//QUESTION: GIVEN AN ARRAY PERFORM LINEAR SEARCH TO FIND TARGET
//CHALLENGES:
//1: ELEMENTS CAN OCCUR MANY TIMES RETURN THE INDEX OF ALL TARGET ELEM. PRESENT IN ARRAY.
//2: RETURN TYPE OF FN MUST BE ArrayList b/z there is other approach too like create a list outside of function.
//3: CAN ONLY CREATE ARRAYLIST IN MAIN FN.
//3: DO NOT CREATE ARRAYLIST INSIDE THE FUNCTION  >>see its 2nd part<<

//Note: This method is good, but sometimes we need other approach covered in 2nd part of this file

import java.util.ArrayList;
public class ReturnArrayList {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,3,3,2,10};
        int target = 3;
     // ArrayList<Integer> list = new ArrayList<>(); also be done like this 👇
        System.out.println(findIndex(arr, target, 0, new ArrayList<>()));
    }

    static ArrayList<Integer> findIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if(index == arr.length) {
            return list;
        }
        if(arr[index] == target) {
            list.add(index);
        }
        return findIndex(arr, target, index+1, list);
    }
}
