/** 
    Adaptation of https://en.wikipedia.org/wiki/Factory_method_pattern
**/

// ========= Product =========
interface Car {
    public String getName();
}

// ========= Concrete products =========
class Renault implements Car {
    public String getName() { return "voiture Renault"; }
}
class Peugeot implements Car {
    public String getName() { return "voiture Peugeot"; }
}

// ========= Creator =========
interface CarFactory {
    public Car makeCar();
}

// ========= Concrete creators =========
class RenaultFactory implements CarFactory {
    public Car makeCar() { return new Renault(); }
}
class PeugeotFactory implements CarFactory {
    public Car makeCar() { return new Peugeot(); }
}

// ========= Client =========
public class CarDemo{
    public static void main(String[] args) {
        CarFactory factory1 = new RenaultFactory();
        Car car1 = factory1.makeCar();
        System.out.println(car1.getName());
        
        CarFactory factory2 = new PeugeotFactory();
        Car car2 = factory2.makeCar();
        System.out.println(car2.getName());
    }
}
