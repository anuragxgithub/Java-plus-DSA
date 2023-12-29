public class Destructor {
    public static void main(String[] args) {
// there is a concept called "destructor" in some programming languages like C++,
// which is used to clean up resources and perform cleanup operations when an object is being
// destroyed or deallocated
// In Java, the garbage collector automatically manages memory de allocation, so there is
// no explicit destructor. Instead, Java provides the concept of finalizers, which are methods
// defined within a class that are automatically invoked by the garbage collector before an object
// is reclaimed.
// In Java, a destructor refers to a special method called finalize() that is defined in the Object class.
// The finalize() method is invoked by the garbage collector before an object is removed from memory.
// However, it's important to note that the use of destructors or explicit memory de allocation is not a
// common practice in Java. Unlike in languages like C++, where developers explicitly manage memory by
// creating destructors, Java uses automatic garbage collection to handle memory management.

        Random obj;   //object obj is declared.
        for (int i = 0; i < 1000000; i++) {
            obj = new Random("Random Name");  // so here everytime the loop runs, new object is created.
        }

    }
}

class Random {
    String name;


    Random(String xyz) {
        System.out.println("a object is created");

    }

//        @Override
//    protected void finalize() throws Throwable {
//        System.out.println("Object is destroyed.");    //this is giving error in new java versions
//    }

}



//NOTE: Remember only basic theory about garbage collection in java and how objects are cleaned up.
// since in java unlike c++ it is not common practice to explicitly de allocate memory as in java it
// is automatically done.
//The garbage collector will automatically handle the cleanup of objects.