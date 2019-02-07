
public class Main{

    /** Nombre d'itération **/
    public static final int N = 100;
    
    public static void main(String[] args) {
    
        var c = new Client();
        c.setContext(new PiContext(N));
        
        double pi;
        
        c.setStrategy(new Pi1Adapter());
        pi = c.calculePi();
        System.out.println("pi1 = " + pi);
        
        c.setStrategy(new Pi2Adapter());
        pi = c.calculePi();
        System.out.println("pi2 = " + pi);
        
        c.setStrategy(new Pi3Adapter());
        pi = c.calculePi();
        System.out.println("pi3 = " + pi);
    }
    
}
