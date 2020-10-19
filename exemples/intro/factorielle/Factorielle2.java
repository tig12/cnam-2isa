/** 
    Factorielle, utilisation de la récursivité
**/
class Factorielle2 {
    public static void main(String[] args) {
        int n = (int)Integer.valueOf(args[0]);
        int f = factorielle(n);
        System.out.printf("Factorielle : %d%n", f);
    }
    
    public static int factorielle(int n){
        if(n < 2){
            return 1;
        }
        return n * factorielle(n - 1);
    }
    
}
