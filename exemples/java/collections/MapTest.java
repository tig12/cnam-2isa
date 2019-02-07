import java.util.*;

class Personne{
    private String nom;
    public Personne(String nom) { this.nom = nom; }
    @Override public String toString() { return nom; }
}

public class MapTest{
    
    public static void main(String[] args) {
        
        // création de la map
        
        Map<String, Personne> map = new HashMap<>();
        map.put("p1", new Personne("Personne 1"));
        map.put("p2", new Personne("Personne 2"));
        map.put("p3", new Personne("Personne 3"));
        
        // Affichage
        
        System.out.println("=== Utilisation de values() ===");
        for (Personne p : map.values()) {
            System.out.println(p); // n'affiche que les valeurs
        }
        
        System.out.println("=== Utilisation de keySet() ===");
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        
        System.out.println("=== Utilisation de entrySet() ===");
        for (Map.Entry<String, Personne> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        System.out.println("=== Utilisation de iterator() ===");
        Iterator<Map.Entry<String, Personne>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Personne> entry = entries.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        System.out.println("=== Utilisation de stream() ===");
        map.forEach((k,v)->System.out.println(k + "  :  " + v));
    }
}