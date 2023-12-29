package ObjectCloning;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human2 h1 = new Human2();
        h1.name = "Anurag";
        h1.age = 22;
        System.out.println(Arrays.toString(h1.arr));

        Human2 h2 = (Human2)h1.clone();  //Object cloning happens here.
        System.out.println(Arrays.toString(h2.arr));
        //Now Twist:
        h2.arr[0] = 100;
        System.out.println(Arrays.toString(h2.arr));
        System.out.println(Arrays.toString(h1.arr));  //HERE ALSO CHANGED.   (SHALLOW COPY)

        //Deep Copy Thing now.
        System.out.println("-------------------------------------------------------");
        DeepCopyDemo d1 = new DeepCopyDemo();
        d1.age = 18;
        System.out.println(Arrays.toString(d1.arr));
        DeepCopyDemo d2 = (DeepCopyDemo)d1.clone();
        System.out.println(Arrays.toString(d1.arr));
        d2.arr[0] = 999;
        System.out.println(Arrays.toString(d1.arr));
        System.out.println(Arrays.toString(d2.arr));  //Now the change reflect to only on the modified array
                                                    // hence validating Deep Copy.


    }
}
//SHALLOW COPY: In shallow copy if the fields of the original array is reference types/non-primitive types/object type
//(eg. arrays) the shallow copy copies the reference to those objects rather than creating new copies of
//the referenced objects themselves.
//That's why making changes in the content of reference types reflect for other original objects
// of that class too.
//-------------------------------------------------------------------
//SO IF YOU WANT TO OVERCOME IT MAKE IT A DEEP COPY LIKE THIS.
//Everything will be same we first create a shallow copy but then point it to the new copied object.
//DEEP COPY : No matter whether the field of actual object if primitive or reference type deep copy makes
// copy(create new copy of objects) of both the types.



