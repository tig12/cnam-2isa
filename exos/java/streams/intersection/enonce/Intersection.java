import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Intersection{
    
    public static void main(String[] args){
        String[] list1 = {
            "Carotte",
            "Chou",
            "Navet",
            "Patate",
            "Radis",
            "Tomate"
        };
        String[] list2 = {
            "Radis",
            "Banane",
            "Pomme",
            "Poire",
            "Prune",
            "Tomate",
        };
        System.out.println(intersection1(list1, list2));
        System.out.println(intersection2(list1, list2));
    }
    
    /** 
        Renvoie une liste contenant les chaînes présentes à la fois dans <code>list1</code> et <code>list2</code>.
        Utilise les itérations classiques
    **/
    public static List<String> intersection1(String[] list1, String[] list2){
        // A implémenter
    }
    
    /** 
        Renvoie une liste contenant les chaînes présentes à la fois dans <code>list1</code> et <code>list2</code>.
        Utilise l'API streams
    **/
    public static List<String> intersection2(String[] list1, String[] list2){
        // A implémenter
    }
    
}
