/** 
    Calcul de Pi en utilisant la formule de Nilakantha.
**/
class Pi3 {
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double pi = calculePi(N);
        System.out.println("pi = " + pi);
    }
    
    /** 
        @param N Nombre de termes utilisés pour calculer la somme
    **/
    public static double calculePi(int N) {
        double i = 1.0;
        double somme = 0.0;
        while(i < N){
            somme += Math.pow(-1.0, i + 1.0) / ( (2.0*i) * (2.0*i + 1.0) * (2.0*i + 2.0) );
            i = i + 1.0;
        }
        
        return 3.0 + (4.0 * somme);
        
    }
}
