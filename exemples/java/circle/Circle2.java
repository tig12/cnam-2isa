public class Circle2 {
    
    private static final int NUM = 500;
    
    private static double sines[] = new double[NUM];
    
    private static double cosines[] = new double[NUM];
    
    static {
        double delta_x = (Circle.PI/2)/(NUM-1);
        double x = 0.0;
        for(int i = 0; i < NUM; i++, x += delta_x) {
            sines[i] = Math.sin(x);
            cosines[i] = Math.cos(x);
        }
    }
    
    public static void main(String[] args){
        System.out.println("NUM = " + NUM);
        System.out.println("delta_x = " + delta_x); // Ne passe pas à la compilation
    }
}