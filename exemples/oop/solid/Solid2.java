
public class Solid2{
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

interface Shape{ }

class Circle implements Shape{
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }
}

class Square implements Shape {
    private double length;
    public Square(double length) { this.length = length; }
    public double getLength() { return length; }
}

class AreaCalculator {

    private Shape[] shapes;

    public AreaCalculator(Shape[] shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double sum = 0.0;
        for(Shape shape : shapes){
            if(shape instanceof Circle){
                sum += Math.PI * ((Circle)shape).getRadius() * ((Circle)shape).getRadius();
            }
            else if(shape instanceof Square){
                sum += ((Square)shape).getLength() * ((Square)shape).getLength();
            }
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
