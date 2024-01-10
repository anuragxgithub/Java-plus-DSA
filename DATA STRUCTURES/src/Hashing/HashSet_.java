/*
 * HashSet is one of the most important data structure out there. Bcz it performs insertion/add ,
 * deletion/remove and search/contains in constant time i.e, O(1) which is really awesome.
 * // Note : this is average time complexity.

 * Before studying it know what is set.
 * A set is an unordered collection of distinct objects. Means no object in set can be duplicated.
 */
package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet_ {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();  // Most of its methods are same as arrayList.

        // insertion/addition       
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(4);
        set.add(5);  // see here I'm adding duplicate value but it won't be add it into the set

        System.out.println(set);   // will not be printed in same order as we inserted them     

        // serach/contains
        if(set.contains(2)) {
            System.out.println("Set contains 2 in it.");
        }

        if(!set.contains(6)) {
            System.out.println("Set does not contains 6 in it.");
        }

        // deletion
        set.remove(5);
        if(!set.contains(5)) {
            System.out.println("Set does not contains 5 in it.");
        }
        
        // size 
        System.out.println("The size of set is : " + set.size());



        // iterator (as like we iterate array by creating iterator in for loop, we can iterate the
        // set with the help of iterator provided in Iterator interface by java)

        Iterator<Integer> it = set.iterator();  // type parameters : the type of elements returned by this iterator
        
        // note iterator() method in Iterator interface return the iterator which we use to iterate
        // our set we got the returned iterator in "it" variable which is of type Iterator.
        
        // initially this 'it' points to some random value like null or something.
        // if we use next() with it then it will start pointing to the elements of set one by one
        // also hashNext() method return whether the next of it has some elements or not. return true if any there otherwise false.

        System.out.println(it.hasNext()); // returns true bcz it has other elements left to iterate

        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // another way to iterate is :
        System.out.println();
        for(int e : set) {
            System.out.print(e + " ");
        }
    }
}
// NOTE : You may find that the set is getting printed in sorted order but that is not guaranteed at all
