/** 
    Illustre différences entre l'opérateur + et concat()
**/
public class Concat{

    public static void main(String[] args){
        String s1 = "abc", s2 = "def"; // noter initialisations multiples pour des variables de même type
        String s3;
        
        s3 = s1.concat(s2);
        System.out.println("Avec concat : s3 = " + s3);
        
        s3 = s1 + s2;
        System.out.println("Avec + : s3 = " + s3);
        
        int i = 4;
        String s4; 
        
        // s4 = s3.concat(i); // pas possible
        s4 = s3 + i;
        System.out.println("s4 = " + s4);
    }

}
