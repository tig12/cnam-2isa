/** 
    Adaptation de
    https://stackoverflow.com/questions/319728/when-do-you-use-the-bridge-pattern-how-is-it-different-from-adapter-pattern
    2018-02-06 09:14:06+01:00
**/

// ===== Client =====
public class VehicleDemo {
    public static void main(String args[]){
        Gear gear;
        
        gear = new ManualGear();
        Vehicle vehicle = new Car(gear);
        vehicle.displayGear();

        gear = new AutomaticGear();
        vehicle = new Car(gear);
        vehicle.displayGear();

        gear = new ManualGear();
        vehicle = new Truck(gear);
        vehicle.displayGear();

        gear = new AutomaticGear();
        vehicle = new Truck(gear);
        vehicle.displayGear();
    }
}


// ===== Implementor interface =====
interface Gear{
    void display();
}

// ===== Concrete Implementors =====
class ManualGear implements Gear{
    public void display(){
        System.out.println("Manual gear");
    }
}

class AutomaticGear implements Gear{
    public void display(){
        System.out.println("Auto gear");
    }
}

// ===== Abstraction (abstract class) =====
abstract class Vehicle {
    Gear gear;
    public Vehicle(Gear gear){
        this.gear = gear;
    }
    abstract void displayGear();
}

// ===== Refined abstractions =====
class Car extends Vehicle{
    public Car(Gear gear){
        super(gear);
    }
    public void displayGear(){
        System.out.print("Car handles ");
        gear.display();
    }
}

class Truck extends Vehicle{
    public Truck(Gear gear){
        super(gear);
    }
    public void displayGear(){
        System.out.print("Truck handles " );
        gear.display();
    }
}
