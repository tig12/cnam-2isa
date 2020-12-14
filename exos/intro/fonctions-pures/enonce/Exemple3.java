
class Exemple3 {

    public static void main(String[] args){
        //long N = Long.MAX_VALUE;
        long N = 100000000;
        for(int i=0; i < 5; i++){
            System.out.println("=== appel testTempsExecution(" + N + ") ===");
            System.out.println(testTempsExecution(N));
        }
    }

    /** 
        Renvoie le temps utilisé pour faire une boucle de N itérations
    **/
    public static long testTempsExecution(long N){
        
        long t1, t2, dt;
        
        t1 = System.currentTimeMillis();
        for(long i=0; i < N; i++){
        }
        t2 = System.currentTimeMillis();
        dt = t2 - t1;
        
        return dt;
    }
}
