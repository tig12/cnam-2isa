import java.util.*;

public class Demo1{
    public static void main(String[] args) {
        
        Collection<String> c = new HashSet<>(); // ensemble vide
        
        // utilitaires fournis par l'API
        Collection<String> d = Arrays.asList("one", "two");
        Collection<String> e = Collections.singleton("three");
        
        // ajout d'éléments
        // renvoient true si la collection change
        c.add("zero");
        c.addAll(d);
        
        // constructeur par recopie - la plupart des implémentation en disposent
        Collection<String> copy = new ArrayList<String>(c);
        
        // suppression d'éléments
        // renvoient true si la collection change, sauf clear()
        c.remove("zero");
        c.removeAll(e);
        c.retainAll(d);
        c.clear();
        boolean b = c.isEmpty(); // true
        int s = c.size(); // 0
        
        c.addAll(copy); // Restore collection from the copy we made
        
        // tests d'appartenance
        // basés sur la fonction clone(), pas sur ==
        b = c.contains("zero"); // true
        b = c.containsAll(d); // true
        
        System.out.println(c); // la plupart des implémentations ont une méthode toString()
        
        // le tableau est une copie, pas une référence vers le même objet
        Object[] elements = c.toArray();
        String[] strings = c.toArray(new String[c.size()]);
        strings = c.toArray(new String[0]); // on passe un tableau vide pour indiquer le type, toArray alloue la taille pour nous
    }
}