
public class Solid1{
    public static void main(String[] args){
        Shape[] shapes = new Shape[]{
            new Circle(3.0),
            new Square(2.0)
        };
        AreaCalculator calculator = new AreaCalculator(shapes);
        System.out.println(calculator.output());
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

    protected Shape[] shapes;

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

    public String output() {
        return "Somme des aires : " + Double.toString(sum());
    }
}