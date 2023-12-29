package OOPs_Properties.Inheritance.TypesOfInheritance.HierarchicalInheritance;

public class Human {
    String name;
    int age;
    String color;

    Human() {
        this.name = "anurag";
        this.age = 19;
        this.color = "black";
    }

    Human(String nam, int umar) {
        this.name = nam;
        this.age = umar;

    }

    public Human(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
//Second Class
class HumanWeight extends Human {
    float wt;

    HumanWeight() {
        super();
        this.wt = 55;
    }

    public HumanWeight(float wt) {
        this.wt = wt;
    }

    public HumanWeight(String name, int age, String color, float wt) {
        super(name, age, color);
        this.wt = wt;
    }
}

//Third Class
class HumanType extends Human {
    String gender;

    HumanType() {
        super();
        this.gender = "Male";
    }

    HumanType(String gender) {
        this.gender = gender;
    }

    public HumanType(String name, int age, String color, String gender) {
        super(name, age, color);
        this.gender = gender;
    }
}
