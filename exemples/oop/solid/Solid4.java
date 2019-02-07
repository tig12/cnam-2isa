
public class Solid4{
    public static void main(String[] args){
        Calculable[] calculables = new Calculable[]{
            new Circle(3.0),
            new Sphere(2.0),
            new Square(4.0),
            new Cube(2.0)
        };
        Calculator calculator = new Calculator(calculables);
        Ouputter outputter = new Ouputter(calculator);
        System.out.println(outputter.outputText());
    }

}

interface Objetct2D {
    public double area();
}

interface Objetct3D {
    public double volume();
}

interface Calculable {
    public double calculate();
}

class Circle implements Objetct2D, Calculable {
    public double radius;
    public Circle(double radius) { this.radius = radius; }
    public double area() { return Math.PI * radius * radius; }                                                                                   
    public double calculate() { return area(); }
}

class Sphere implements Objetct3D, Calculable {
    public double radius;
    public Sphere(double radius) { this.radius = radius; }
    public double volume() { return Math.PI * radius * radius * radius * 4.0 / 3.0; }
    public double calculate() { return volume(); }
}

class Square implements Objetct2D, Calculable {
    public double length;
    public Square(double length) { this.length = length; }
    public double area() { return length * length; }
    public double calculate() { return area(); }
}

class Cube implements Objetct3D, Calculable {
    public double length;
    public Cube(double length) { this.length = length; }
    public double volume() { return length * length * length; }
    public double calculate() { return volume(); }
}

class Calculator {

    protected Calculable[] calculables;

    public Calculator(Calculable[] calculables) {
        this.calculables = calculables;
    }

    public double sum() {
        double sum = 0.0;
        for(Calculable calculable : calculables){
            sum += calculable.calculate();
        }
        return sum;
    }
}

class Ouputter {
    private Calculator calculator;
    
    public Ouputter(Calculator calculator) {
        this.calculator = calculator;
    }
    
    public String outputText() {
        return "Somme des valeurs : " + Double.toString(calculator.sum());
    }
    
    public String outputJSON() { return "not implemented"; }
}