/**
    Un Circle est caractérisé par son rayon
    Un PlaneCircle est en plus caractérisé par les coordonnées de son centre dans un plan
**/
public class PlaneCircle extends Circle {
    
    private final double cx, cy;    // coordonnées du centre
    
    public PlaneCircle(double r, double x, double y) {
        super(r);
        this.cx = x;
        this.cy = y;
    }
    
    public double getCentreX() { return cx; }
    
    public double getCentreY() { return cy; }
    
    public boolean isInside(double x, double y) {
        double dx = x - cx, dy = y - cy;
        double distance = Math.sqrt(dx*dx + dy*dy); // théorème de Pythagore
        return (distance < getRadius());      // this.getRadius() nécessaire car Circle.r est private
    }
}
