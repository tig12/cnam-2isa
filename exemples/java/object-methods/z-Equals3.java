
/** 
    Illustre le comportement particulier de String.
    Pour tout autre type référence, s3 == s4 et s3.equals(s4) renverraient false.
    Dans le cas de String, ça renvoie true suite à une optimisation du compilateur.
**/
public class Equals3 {
    public static void main(String[] args) {
        String s1 = "toto";
        String s2 = s1;
        System.out.println("s1 == s2 ? " + (s1 == s2));
        System.out.println("s1.equals(s2) ? " + (s1.equals(s2)));
        
        String s3 = "toto";
        String s4 = "toto";
        // String s4 = "to" + "to"; // même comportement
        System.out.println("\ns3 == s4 ? " + (s3 == s4));
        System.out.println("s3.equals(s4) ? " + (s3.equals(s4)));
        
        String s5 = "to";
        s5 += "to";
        System.out.println("\ns3 == s5 ? " + (s3 == s5));
        System.out.println("s3.equals(s5) ? " + (s3.equals(s5)));
        
        // Contrairement à s2 et s4, renvoie false
        StringBuilder sb1 = new StringBuilder("toto");
        StringBuilder sb2 = new StringBuilder("toto");
        System.out.println("\nsb1 == sb2 ? " + (sb1 == sb2));
        System.out.println("sb1.equals(sb2) ? " + (sb1.equals(sb2)));
    }
}
