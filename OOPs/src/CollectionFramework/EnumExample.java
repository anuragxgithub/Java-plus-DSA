package CollectionFramework;
//In Java, an enum (short for enumeration) is a special data type that allows you to define a fixed
//set of named constants. It provides a way to represent a group of related values as a distinct type,
//making the code more readable, maintainable, and type-safe.
//In this example, an enum named Day is defined with seven constants representing the days of the week.
//The constants (MONDAY, TUESDAY, etc.) are implicitly declared as public, static, and final.
//They can be accessed using the dot notation, such as Day.MONDAY.
public class EnumExample {

    enum Week {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
        // these are enum constants
        // public static final    (by default)
        // since its final you can't create child enums
        // type of enum here is Week


        Week() {        //Constructor
            System.out.println("Constructor called for: " + this);
            //This constructor got called for all the objects.
        }

        //This is not public or protected only private or default.
        //why? bcz we don't want to create new objects
        // this is not enum concept that's why.

    }

    public static void main(String[] args) {
        Week din;
        din = Week.Monday;   //Note: The constructor got called for all the enum constants.
                             // internally: public static final Week Monday = new Week();
        System.out.println(din);
        System.out.println(din.ordinal());
        // Returns the ordinal of this enumeration constant (its position in its enum declaration, where
        // the initial constant is assigned an ordinal of zero)

        //You can also iterate over them:
//        for (Week day : Week.values()) {
//            System.out.println(day);
//        }

        System.out.println(Week.Thursday);  //can also be accessed like this using dot notation.
    }
}

//Points :
//enum can implements as many interfaces but it can't extend any class.
//check it out by implementing the A interface created in this package remember to implement from
//enum not from the class.

//NOTE: You can also explore more about enums like can it store integer values or not.