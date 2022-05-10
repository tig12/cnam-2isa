
public class Main {
    
    public static void main(String[] args){
        
        // Attention, cette ligne est à modifier dans une des deux implémentations
        PileI<String> p = new StackAdapter<>();
        
        p.empiler("toto");
        String s = p.depiler();
        boolean b = p.estVide();
    }
}
