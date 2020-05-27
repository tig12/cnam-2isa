/** 
    Pour comparer les temps d'exécution entre FileReader et BufferedReader
    Résultat :
        java BufferedReaderCompare 
        Avec FileReader : 65 ms
        Avec BufferedReader : 28 ms
**/
import java.io.*;

class BufferedReaderCompare{
    
    public static void main(String[] args){
        long t1, t2, t3, t4, dt1, dt2;
        int character;
        
        // Avec FileReader                                                
        t1 = System.currentTimeMillis();                                  
        for(int i=0; i < 1000; i++){
            try (Reader in = new FileReader("test.txt")) {
                while((character = in.read()) != -1) {
                    //System.out.println(character);
                }
            }
            catch (IOException e) { }
        }
        t2 = System.currentTimeMillis();
        dt1 = t2 - t1;                                            
        System.out.println("Avec FileReader : " + dt1 + " ms");
        
        // Avec BufferedReader
        t3 = System.currentTimeMillis();
        for(int i=0; i < 1000; i++){
            try (Reader in = new BufferedReader(new FileReader("test.txt"))) {
                while((character = in.read()) != -1) {
                    //System.out.println(character);
                }
            }
            catch (IOException e) { }
        }
        t4 = System.currentTimeMillis();
        dt2 = t4 - t3;                                            
        System.out.println("Avec BufferedReader : " + dt2 + " ms");
    }
}