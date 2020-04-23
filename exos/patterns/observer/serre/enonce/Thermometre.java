public class Thermometre{

    private String name;
    
    private static final double deuxpi = 2.0 * Math.PI;
    
    public Thermometre(String name){
        this.name = name;
    }
    
    /** 
        Simule une courbe de temperature avec un minimum à 4h (12°) et un maximum à 16h (30°)
    **/
    public double getTemperature(int minutes){
        double m = (double) minutes;
        double t = ((m - 600.0) * deuxpi / 1440.0) % deuxpi;
        return 9.0 * Math.sin(t) + 21.0;
    }

}