import java.util.List;
import java.util.Arrays;

/** 
    Test de l'exemple donné par Oracle sur 
    https://docs.oracle.com/javase/tutorial/java/generics/unboundedWildcards.html
    Montre que 
    public static void printList(List<? extends Object> list)
    marche aussi bien que
    public static void printList(List<? extends Object> list)
    
**/
public class UnboundedOracle{
    
    public static void main(String[] args){
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }
    
    public static void printList(List<? extends Object> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }

}