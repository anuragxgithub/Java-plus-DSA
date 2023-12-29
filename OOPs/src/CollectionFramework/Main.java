//In Java, the Collection Framework is a set of interfaces, classes, and algorithms provided by the
//Java API to handle groups of objects. It offers a unified and standardized way to manipulate and
//store collections of elements.
//The java.util package contains all the classes and interfaces for the Collection framework.
//https://static.javatpoint.com/images/java-collection-hierarchy.png
//https://www.javatpoint.com/collections-in-java

/*
The main components of the Collection Framework are:

Interfaces: The framework includes several core interfaces that define different types of collections and
their behavior. Some of the key interfaces are:

Collection: It is the root interface that defines the basic operations common to all collection types, such
as adding, removing, and querying elements.
List: An ordered collection that allows duplicate elements. It supports positional access and provides
methods to add, remove, and search elements by index.
Set: A collection that does not allow duplicate elements. It defines the behavior of a mathematical set,
including operations like union, intersection, and difference.
Map: A key-value pair collection that maps unique keys to values. It provides methods to add, retrieve,
and remove elements based on their associated keys.
Implementations: The framework provides various concrete classes that implement the collection interfaces.
These classes offer different ways to store and organize the elements. Some commonly used implementations are:

ArrayList, LinkedList, Vector, Stack: Implementations of the List interface using dynamic arrays and linked lists, respectively.
HashSet, TreeSet: Implementations of the Set interface using hash tables and binary search trees, respectively.
HashMap, TreeMap: Implementations of the Map interface using hash tables and binary search trees, respectively.
Algorithms: The framework includes algorithms that operate on collections, such as sorting, searching, and
data manipulation. These algorithms are provided as static methods in the Collections class, and they can be
applied to any collection that implements the appropriate interface.
 */
package CollectionFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        list2.add(12);
        list2.add(54);
        list2.add(43);
        list2.add(67);
        System.out.println(list2);

        List<Integer> list3 = new Vector<>();
        list3.add(2);
        list3.add(9);
        list3.add(43);
        System.out.println(list3);
    }

    //Know that Arraylist, linkedList, vector ... classes implements the list interface.
    //Also, about other interfaces in tha java collections framework using the link i provided above.
}
