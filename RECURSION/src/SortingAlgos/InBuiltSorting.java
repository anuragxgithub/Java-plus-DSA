package SortingAlgos;

import java.util.Arrays;
//Come to this after SortingAlgos.QuickSort
public class InBuiltSorting {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,74,2,3,45,32};
        Arrays.sort(arr);
        //Note:
        //Go check out the internal implementation of this sorting technique by (ctrl+click) also find out the
        //time complexity of this method() best and worst. Optimised way is used there. Just to know don't mug up.
        //You can use these inbuilt methods in interview if a question involves sorting no need to write whole
        //big code (lol use only when sorting is not main point there.)
        System.out.println(Arrays.toString(arr));
    }
}
