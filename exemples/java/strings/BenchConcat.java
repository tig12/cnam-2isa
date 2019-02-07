/** 
    Compare rapidité d'exécution entre concaténation avec String et avec StringBuilder
**/
public class BenchConcat{
    
    private final static int N = 100000;
    private final static String test = "A";

    public static void main(String[] args){
        
        long t1, t2, dt;
        
        t1 = System.currentTimeMillis();
        concatString();
        t2 = System.currentTimeMillis();
        dt = t2 - t1;
        System.out.println("concat String : dt = " + dt);
        
        t1 = System.currentTimeMillis();
        concatStringBuilder();
        t2 = System.currentTimeMillis();
        dt = t2 - t1;
        System.out.println("concat StringBuilder : dt = " + dt);
        
    }
    
    private static void concatString(){
        String res = "";
        for(int i = 0; i < N; i++){
            res += test;
        }
    }

    private static void concatStringBuilder(){
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i < N; i++){
            res.append(test);
        }
    }

}