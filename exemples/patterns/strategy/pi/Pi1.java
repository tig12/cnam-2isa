/** 
    Calcul de Pi en utilisant la formule d'Euler (1735)
**/
class Pi1 {
    
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
            somme += 1.0/(i*i);
            i = i + 1.0;
        }
        
        return Math.sqrt(6.0 * somme);
        
    }
}
