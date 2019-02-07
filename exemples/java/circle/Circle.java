public class Circle {

    public static final double PI= 3.14159;

    public static double radiansToDegrees(double radians) { return radians * 180 / PI; }
    
    private double r;

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
