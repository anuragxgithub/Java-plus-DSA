package staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    //but what if there is any property which are common for all the objects of class Human?
    //then that will be object independent so here we can take example of population which are common to
    //all objects of human class. Such members (variables or method) are called static members of class, that has nothing to do
    //with objects.  Only if you put static before them.
    //Conclusion⭐: If you declare a member static, that means it belongs to the class itself rather than to
    //any specific object of the class.
    static long population;


    //This constructor is called as many times as the new object is created
    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population = population+1;   //remember by default the instance variables are 0 or null.

        //here we put human.population rather than this keyword b/z it is a convention that when the variable
        //is static it should be accessed with the class name. although it will work with this too.

        //Now what would happen if the population field is of long only and inside the constructor
        // this.population is written what will be the output of h1.population and h2.population
        // it will be 1 for both b/z for h1 it will treat population separately and so for the h2.
        //but after static it is treated as the common for all objects.
    }
}
