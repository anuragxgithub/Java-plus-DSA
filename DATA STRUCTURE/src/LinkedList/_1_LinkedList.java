// Before moving ahead lets see how in built LL works

package LinkedList;

import java.util.LinkedList;
import java.util.Iterator;

public class _1_LinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(12);     // adds in the last of the list
        linkedList.add(43);
        linkedList.add(18);
        linkedList.add(23);
        System.out.println(linkedList);

        System.out.println(linkedList.size());  // size

        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.addFirst(1);
        linkedList.addLast(99);
        System.out.println(linkedList);

        // linkedList.clear();  // removes all elements from the list
        System.out.println(linkedList.get(2));  // here we are traversing from head to 2 node ahead to get this value not directly as like in array or arrayList

// NOTE: IN A STANDARD SINGLY-LINKED LIST, YOU DON'T HAVE DIRECT ACCESS TO ELEMENTS BY INDEX AS YOU
// DO WITH ARRAYS OR ARRAYLIST. YOU CAN REMOVE ELEMENTS OR GET ELEMENTS AT A SPECIFIC INDEX BY
// ITERATING THROUGH THE LIST STARTING FROM THE HEAD AND MOVING THROUGH EACH ELEMENT UNTIL YOU 
// REACH THE DESIRED INDEX. That means it won't work in CONSTANT TIME as like in the case of array or arrayList.

        // Iterating through LinkedList
        // 1) suing for each loop
        for(int e : linkedList) {
            System.out.print(e + " ");
        }
        System.out.println();
        //2 ) Using iterator
        Iterator<Integer> it = linkedList.iterator();  // Integer bc list has int values 
        while(it.hasNext()) {   // hasNext() will be true till there are elements present in list
            // as we know at first it will point to null using next() method we have to iterate over next next elements
            System.out.print(it.next() + " ");
        }
        System.out.println();
        // 3) using forEach() method
        linkedList.stream().forEach(item -> System.out.print(item + " "));


        // you can check out other methods too.
    }
}
