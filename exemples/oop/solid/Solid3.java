
public class Solid3{
    public static void main(String[] args){
        Shape[] shapes = new Shape[]{
            new Circle(3.0),
            new Square(2.0)
        };
        AreaCalculator calculator = new AreaCalculator(shapes);
        AreaOuputter outputter = new AreaOuputter(calculator);
        System.out.println(outputter.outputText());
    }

}

interface Shape{
    public double area();
}

class Circle implements Shape{
    public double radius;
    public Circle(double radius) { this.radius = radius; }
    public double area() { return Math.PI * radius * radius; }
}

class Square implements Shape {
    public double length;
    public Square(double length) { this.length = length; }
    public double area() { return length * length; }
}

class AreaCalculator {

    private Shape[] shapes;

    public AreaCalculator(Shape[] shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double sum = 0.0;
        for(Shape shape : shapes){
            sum += shape.area();
        }
        return sum;
    }
}

class AreaOuputter {
    private AreaCalculator calculator;
    
    public AreaOuputter(AreaCalculator calculator) {
        this.calculator = calculator;
    }
    
    public String outputText() {
        return "Somme des aires : " + Double.toString(calculator.sum());
    }
    
    public String outputJSON() { return "not implemented"; }
}