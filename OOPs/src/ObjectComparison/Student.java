package ObjectComparison;

import java.util.Arrays;
import java.util.Comparator;

//First read the main method. Then come here.
//Since Comparable interface is generic interface so, I have to provide the type too.
//I want to compare Student type with Student type only so Putting Student.
//And also since Comparable is interface I have to override all the methods of it.
public class Student implements Comparable<Student> { //
    int rollNo;
    float marks;

    Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        System.out.println("In compareTo method");
//        return 0; by default it was like this but, we want it to provide
//        < 0 when the thing we want to compare is less than the object o.
//        and 0 when equal.  > 0 when greater.
        int diff = (int)(this.marks - o.marks);  //here we specified that we want to compare marks.
        return diff;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }
}


class Main {
    public static void main(String[] args) {
        Student anurag = new Student(23, 99.6f);
        Student kunal = new Student(12, 98.4f);

        //Now what if we compare objects anurag and kunal. It is showing error bcz it is confused
        //which thing to compare marks or rollNo. to fix this we use(implement) 'Comparable' interface provided by
        //java. In student class wee have to do that.
//        if(anurag > kunal) {
//            System.out.println("Anurag has more marks.");
//        }
        //So we will not follow the above traditional way to compare rather we use:
        //our overridden method which we override from the Comparable interface.
//        if (anurag.compareTo(kunal) > 0) {
//            System.out.println("Anurag has more marks!");
//        }   //anurag.marks and kunal.marks are going to be compared.


        //Now let's do some experiment.
        Student rahul = new Student(10, 23.6f);
        Student arpit = new Student(38, 93.6f);
        Student sachin = new Student(19, 76.6f);

        Student[] list = {anurag, kunal, rahul, arpit, sachin}; //array of objets
        System.out.println(Arrays.toString(list));  //again u can't directly print objects import toString first alt+insert.
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        //Arrays.sort(list) compared based on the object because we implemented the compareTo to do so.
        //NOTE: you can change the body of toString method according to u like what you want it to return or not.
        //YOu can make it return only marks or only roll no....etc.


        //lol one last thing : Arrays.sort() method has its own comparator interface.
        //can be used like this:

//        Arrays.sort(list, new Comparator<Student>() {  //I Just wrote com and hit tab didn't write the code on my own
//            @Override
//            public int compare(Student o1, Student o2) {
////                return 0; //by default
//                //but, I will modify:
//                return (int)(o1.marks - o2.marks);  //swaps by its own
//            }
//        });
//        System.out.println(Arrays.toString(list));
    }
}
