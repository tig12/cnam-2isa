
import java.util.Locale;

/** 
    Tests de printf() et String.format()
    Résultats dans les commentaires valables sur une machine dont la locale est "fr"
**/
public class Format{

    public static void main(String[] args){
        String str = "toto";
        System.out.printf("str = %s%n", str); // str = toto
        System.out.printf("str = %S%n", str); // str = TOTO
        
        double dbl = 12.0;
        System.out.printf("dbl = %f%n", dbl); // dbl = 12,000000
        System.out.printf("dbl = % f%n", dbl); // dbl =  12,000000
        System.out.printf("dbl = %+f%n", dbl); // dbl = +12,000000
        System.out.printf("dbl = %.2f%n", dbl); // dbl = 12,00
        
        var locale = new Locale("en");
        System.out.printf(locale, "dbl = %f%n", dbl); // dbl = 12.000000
        
        int i = 4500;
        System.out.printf("i = %d%n", i); // i = 4500
        System.out.printf("i = %,d%n", i); // i = 4 500
        System.out.printf(locale, "i = %,d%n", i); // i = 4,500
        
        String str2;
        str2 = String.format("%s", str);
        System.out.println(str2); // toto
    }

}
