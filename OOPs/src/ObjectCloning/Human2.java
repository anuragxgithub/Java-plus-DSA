package ObjectCloning;
//Here we will talk about shallow and deep copy.
public class Human2 implements Cloneable {
    String name;
    int age;
    int[] arr = new int[]{3,4,5,3,2,88,34};

    public Object clone() throws CloneNotSupportedException {
        //Shallow Copy
        return super.clone();
    }
}
//SHALLOW COPY: In shallow copy if the fields of the original array is reference types/non-primitive types/object type
//(eg. arrays) the shallow copy copies the reference to those objects rather than creating new copies of
//the referenced objects themselves.
//That's why making changes in the content of reference types reflect for other original objects
// of that class too.

//SO IF YOU WANT TO OVERCOME IT MAKE IT A DEEP COPY LIKE THIS.
//Everything will be same we first create a shallow copy but then point it to the new object.
//DEEP COPY : No matter whether the field of actual object if primitive or reference type deep copy makes
// copy(create new copy of objects) of both the types.
class DeepCopyDemo implements Cloneable {
    int age;
    int[] arr = new int[]{44,3,6,7,84,33,67};

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //Deep copy example
        DeepCopyDemo DeepCopy = (DeepCopyDemo)super.clone(); //This is actually shallow copy
        DeepCopy.arr = new int[DeepCopy.arr.length];
        for (int i = 0; i < DeepCopy.arr.length; i++) {
            DeepCopy.arr[i] = this.arr[i];
        }
        return DeepCopy;
    }
}