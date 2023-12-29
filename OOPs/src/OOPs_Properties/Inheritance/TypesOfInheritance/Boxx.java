package OOPs_Properties.Inheritance.TypesOfInheritance;
//Tip: when the child class constructor has arguments which are in parent class in this case always
//     put super() after that constructor. Simple logic.
public class Boxx {
    double l;
    double b;
    double h;
    Boxx() {  //Non parameterized constructor
        this.l = -1;
        this.b = -1;
        this.h = -1;
    }

        //cube
    Boxx(double side) {   //Parameterized constructor
        this.l = side;
        this.b = side;
        this.h = side;
    }

    Boxx(double len, double br, double he) {      //Parameterized constructor
        this.l = len;
        this.b = br;
        this.h = he;
    }

    Boxx(Boxx obj) {   //Copy constructor
        this.l = obj.l;
        this.b = obj.b;
        this.h = obj.h;
    }
}

class boxWeight extends Boxx {
    double wt;

    boxWeight() {
        super();   //Call the constructor of the immediate parent class above it
        this.wt = -1;
    }

    boxWeight(double wt) {

    }
    boxWeight(double side, double weight) {
        super(side);
        this.wt = weight;
    }

    boxWeight(double len, double bred, double ht, double wt) {
        super(len, bred, ht);  //Call the constructor of the immediate parent class above it
        this.wt = wt;

    }
}

class boxPrice extends boxWeight {
    double cost;

    boxPrice() {
        super();  //Call the constructor of the immediate parent class above it
        this.cost = -1;
    }

    public boxPrice(double weight, double cost) {
        super(weight);
        this.cost = cost;
    }

    public boxPrice(double len, double bred, double ht, double wt, double cost) {
        super(len, bred, ht, wt);
        this.cost = cost;
    }
}

//here one subclass extends single super class.