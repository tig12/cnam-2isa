/* Encapsulated family of Algorithms
 * Interface and its implementations
 */
interface IBrakeBehavior {
    public void brake();
}

class BrakeWithABS implements IBrakeBehavior {
    public void brake() {
        System.out.println("Brake with ABS applied");
    }
}

class Brake implements IBrakeBehavior {
    public void brake() {
        System.out.println("Simple Brake applied");
    }
}

/* Client that can use the algorithms above interchangeably */
abstract class Car {
    protected IBrakeBehavior brakeBehavior;

    public void applyBrake() {
        brakeBehavior.brake();
    }

    public void setBrakeBehavior(final IBrakeBehavior brakeType) {
        this.brakeBehavior = brakeType;
    }
}

/* Client 1 uses one algorithm (Brake) in the constructor */
class Sedan extends Car {
    public Sedan() {
        this.brakeBehavior = new Brake();
    }
}

/* Client 2 uses another algorithm (BrakeWithABS) in the constructor */
class SUV extends Car {
    public SUV() {
        this.brakeBehavior = new BrakeWithABS();
    }
}

/* Using the Car example */
class CarExample {
    public static void main(final String[] arguments) {
        Car sedanCar = new Sedan();
        sedanCar.applyBrake();  // This will invoke class "Brake"

        Car suvCar = new SUV();
        suvCar.applyBrake();    // This will invoke class "BrakeWithABS"

        // set brake behavior dynamically
        suvCar.setBrakeBehavior( new Brake() );
        suvCar.applyBrake();    // This will invoke class "Brake"
    }
}