/*
★) STRING 'LITERAL' VS STRING 'OBJECT'
    1. String Literal:
    - A string literal is a sequence of characters enclosed in double quotes, like `"Anurag"`.
    - String literals are stored in a special area of heap memory called the "string pool" or "constant pool".
    - String literals are automatically 'interned' by the Java compiler, which means that if multiple string literals with the same content are encountered, they will all refer to the same memory location (the same string object in string pool). This is done to conserve memory and improve performance when comparing strings using the `==` operator.

    2. String Object:
    - A string object is created using the `new` keyword, like `new String("Anurag")`.
    - String objects are stored in the heap memory, and a new memory allocation is made for each string object, even if it has the same content as an existing string.
    - String objects are not automatically interned like string literals. Each string object is a separate instance with its own memory space.

★) == operator vs .equals():
== operator return true if both the operand refers to the same object in the memory. We know that primitive types are directly stored in stack memory i.e, they refer to their actual value not any address. Eg : a = 5 then a is pointing to 5 itself. So it is used to compare primitive types. But if you compare object/reference type with == then you
might get error How? let's see. Let's take example of string object. If we create str1 = "Anurag". So str1 is holding the memory address of object which is in heap memory. Now again if we create str2 = "Anurag" then java do not create a new object rather str2 will point to the same object in String Pool so str2 & str1 are referring to the same memory
address thus if we do str1 == str2 it will give true bcz both are referring to the same object in memory("Anurag"). But if we create string object not literal then they will have their separate memory addresses ref. variables do not refer to the same object, so it will return true if we use == operator with string 'object'.
Q) So can we say that using == with string literal would always give correct result??
Ans : Not really bcz lets say you have two string literals of same content but one is loaded from the different class then they will refer to different memory locations of string pool so in this case == will not give correct result instead of giving true it will give false.
So, always use == to compare only primitives bcz they refer to the actual values not any address. Or when you want to know the reference of two variables whether they are same or not then use == operator. Otherwise use .equals() to compare the content of object types.
 */

public class String_LiteralVsObject {
    public static void main(String[] args) {
        String x = "Anurag";      //x is a string "literal" will be stored in string pool
        String y = "Anurag";      // due to automatic string interning in java y will not point to new obj. in string pool rather it will point to the same object of x to optimise memory usage. So x and y is having same address that mean they are pointing to the same obj.
        System.out.println(x == y); // should give true

        String str1 = new String("Rahul");   // str1 is a string "obj" and will be stored in heap memory
        String str2 = new String("Rahul");   // str2 is a string obj it will have its own memory location str1 and str2 reference variables will point to different objects in heap.
        System.out.println(str1 == str2); // should give false bcz referring to different objects in memory although the content is same.
        System.out.println(str1.equals(str2)); // should give true bcz it checks the actual content of the reference type variables(Non primitives)

        String s1 = new String("Krishna"); // string obj in heap memory
        String s2 = "Krishna";      // str literal in heap memory in string pool
        // s1 and s2 will point to different obj in memory simple. s2 is in string pool and s1 is somewhere in heap memory but not in string pool.
        String s3 = "Krishna";      // str literal in heap memory in string pool
        System.out.println(s1 == s2);  // should give false
        System.out.println(s2 == s3);  // will give true


    }
}
