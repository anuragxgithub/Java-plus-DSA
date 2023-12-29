package ObjectDemo;
//As we know that every class in java implicitly or explicitly extends/inherits Object class.
//Here we will explore more about this Object class.
public class ObjectDemo {

    //Here we will override some methods present in the object class.
    //See here we are able to override, so it is proved that this class is implicitly extending the object class.
    //all the overriding methods are not written by me just use shortcut alt + insert.
    int num;
    public ObjectDemo(int number) {
        this.num = number;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //Checks the actual content of object
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //This one will not be covered now.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    //Already covered, when we directly print the object.
    @Override
    public String toString() {
        return super.toString();
    }

//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();   //This is giving error we have to check why in the documentation. Already covered Destructor. Not imp.
//    }


    public static void main(String[] args) {
        String name = "anurag";
        String naam = new String("anurag");
        System.out.println(name == naam);   //checks if both the variables are pointing to the same object or not or same memory location.
        System.out.println(name.equals(naam));  //Checks the actual content of object

        ObjectDemo obj = new ObjectDemo(34);
        System.out.println(obj.hashCode()); //hashCode is basically the unique representation of an object via a number.
        //Return hashcode value of that object.
        ObjectDemo obj2 = new ObjectDemo(34);
        System.out.println(obj2.hashCode());
        ObjectDemo obj3 = obj2;
        System.out.println(obj3.hashCode());
        //will learn how these are implemented when we study hashMap


        //An operator you can use:
        //1) instanceof : return true if the provided object is actually the object of provided class.
        System.out.println(obj instanceof Object); //Another proof that obj is implicitly inherited Object class.
        System.out.println(obj instanceof ObjectDemo);

        //A method you can use:
        //2) getClass() : gives the class of the provided object.
        System.out.println(obj.getClass());
        //NOTE: there are various methods you can use with getClass like getName and many just
        //write obj.get you will get many recommendations.
        System.out.println(obj.getClass().getName());
        //basically provide data/information of the class.

    }
}
