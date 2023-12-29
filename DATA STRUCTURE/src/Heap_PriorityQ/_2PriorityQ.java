// This demonstrates how to use a PriorityQueue with "custom objects" and custom comparisons to
// order them according to a specific criterion (in this case, the rank of students).
package Heap_PriorityQ;

// import java.util.Comparator;
import java.util.PriorityQueue;

public class _2PriorityQ {
    static class Student implements Comparable<Student> { // fn overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;  // in java if compareTo method gives 0 then (obj1 == obj2) and if +ve value then (obj1 > obj2) and if -ve value then (obj2 > obj1)
        }
    // this is how we compare the objects of a class here we are comparing the rank of objects of class we can't directly compare objects
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Aman", 2));
        pq.add(new Student("Anurag", 1));
        pq.add(new Student("Rohit", 25));
        pq.add(new Student("Rahul", 10));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);   // . operator is used to access the data member of a class
            pq.remove();
        }
    }
}

// You can use Comparator.reverseOrder() to reverse the order
// Not only rank now you can compare the names too to in compareTo method like which you can give
// priority according to alphabet.