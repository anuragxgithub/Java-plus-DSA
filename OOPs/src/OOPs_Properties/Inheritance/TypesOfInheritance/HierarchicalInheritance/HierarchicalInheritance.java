package OOPs_Properties.Inheritance.TypesOfInheritance.HierarchicalInheritance;


//Hierarchical Inheritance : In Hierarchical inheritance, single super class is inherited by multiple sub classes.
//OR multiple sub classes extends a single super class.
public class HierarchicalInheritance {
    public static void main(String[] args) {
        HumanWeight w1 = new HumanWeight();
        System.out.println(w1.wt);
        System.out.println(w1.name); // name is not the property of HumanWeight class but it
        // is inherited it that is why we are able to use it.

        HumanType h2 = new HumanType("alan", 12, "white", "Male");

        System.out.println(h2.name + " " + h2.age + " " + h2.color + " " + h2.gender);

    }
}
