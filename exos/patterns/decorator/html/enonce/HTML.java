
/** Interface implémentée par le composant et les décorateurs **/
interface TexteI{
    public String toHTML();
}

// ICI, classes du pattern décorateur à implémenter

/** Code client **/
public class HTML{
    public static void main(String[] args){
        
        String theString = "Un texte dans une page HTML";
        
        TexteI t1 = new Texte(theString);
        
        System.out.println("=== pas de décoration ===");
        System.out.println(t1.toHTML());
        
        TexteI t2 = new I(new Texte(theString));
        System.out.println("\n=== décoration avec I ===");
        System.out.println(t2.toHTML());
        
        TexteI t3 = new B(new I(new Texte(theString)));
        System.out.println("\n=== décoration avec I et B ===");
        System.out.println(t3.toHTML());
        
        TexteI t4 = new U(new I(new Texte(theString)));
        System.out.println("\n=== décoration avec I et U ===");
        System.out.println(t4.toHTML());
    }
}
