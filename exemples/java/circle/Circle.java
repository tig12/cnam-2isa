
public class Circle {

    public static final double PI= 3.14159;

    private double r;

    public static double radiansToDegrees(double radians) { return radians * 180 / PI; }
    
    public Circle() { this(1.0); }
    
    public Circle(double r) { this.r = r; }
    
    public double getRadius() { return r; }
    
    public void setRadius(double r) {
        if (r < 0.0){
            throw new IllegalArgumentException("radius may not be negative.");
        }
        this.r = r;
    }
    
    public double area() { return PI * r * r; }
    
    public double circumference() { return 2 * PI * r; }
    
}

class Main{
    // ***************************************
    public static void main(String[] args){
        
        System.out.println("Circle.radiansToDegrees(Circle.PI) = " + Circle.radiansToDegrees(Circle.PI));
        
        Circle c1 = new Circle();
        System.out.println("c1.getRadius() = " + c1.getRadius());
        System.out.println("c1.area() = " + c1.area());
        System.out.println("c1.radiansToDegrees(Circle.PI) = " + c1.radiansToDegrees(Circle.PI));
        
        System.out.println();
        
        Circle c2 = new Circle(2.0);
        System.out.println("c2.getRadius() = " + c2.getRadius());
        System.out.println("c2.area() = " + c2.area());
        c2.setRadius(3.0);
        System.out.println("Change rayon");
        System.out.println("c2.getRadius() = " + c2.getRadius());
        System.out.println("c2.area() = " + c2.area());
        
        
    }
    
}