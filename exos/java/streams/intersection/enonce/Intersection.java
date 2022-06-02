import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Intersection{
    
    public static String[] list1 = {
        "Carotte",
        "Chou",
        "Navet",
        "Patate",
        "Radis",
        "Tomate"
    };
    public static String[] list2 = {
        "Radis",
        "Banane",
        "Pomme",
        "Poire",
        "Prune",
        "Tomate",
    };
        
    public static void main(String[] args){
        System.out.println("intersection1\t" + intersection1(list1, list2));
        System.out.println("intersection2\t" + intersection2(list1, list2));
        System.out.println("intersection3\t" + intersection3(list1, list2));
    }
    
    /** 
        Renvoie une liste contenant les chaînes présentes à la fois dans <code>list1</code> et <code>list2</code>.
        Utilise les itérations classiques (boucles for sur tableaux avec index).
    **/
    public static List<String> intersection1(String[] list1, String[] list2){
        // A implémenter
    }
    
    /** 
        Renvoie une liste contenant les chaînes présentes à la fois dans <code>list1</code> et <code>list2</code>.
        Les tableaux sont convertis en ArrayList, utilise une boucle "foreach" pour itérer.
    **/
    public static List<String> intersection2(String[] list1, String[] list2){
        // A implémenter
    }
    
    /** 
        Renvoie une liste contenant les chaînes présentes à la fois dans <code>list1</code> et <code>list2</code>.
        Utilise l'API streams
    **/
    public static List<String> intersection3(String[] list1, String[] list2){
        // A implémenter
    }
    
}
