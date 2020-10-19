/** 
    Factorielle, utilisation d'une boucle
**/
class Factorielle1 {
    public static void main(String[] args) {
        int n = (int)Integer.valueOf(args[0]);
        int f = factorielle(n);
        System.out.printf("Factorielle : %d%n", f);
    }
    
    public static int factorielle(int n){
        if(n == 0){
            return 1;
        }
        int res = 1;
        for(int i=1; i <= n; i++){
            res *= i; // res = res * i
        }
        return res;
    }
    
}
