
import java.util.List;
import java.util.ArrayList;

/** 
    Code client du pattern memento : 
    manipule le vaisseau, le caretaker, mais n'accède jamais au memento lui-même.
**/
class Main {
    public static void main(String[] args) {
        
        var v = new Vaisseau();
        var caretaker = new VaisseauCaretaker(v);
        
        caretaker.saveState();
        System.out.println("=== Etat initial ===");
        System.out.println(v);
        
        v.accelerer(10.0f);
        v.tourner(-10.0f);
        caretaker.saveState();
        System.out.println("\n=== Après modification 1 ===");
        System.out.println(v);
        
        v.accelerer(50.0f);
        v.tourner(-20.0f);
        caretaker.saveState();
        System.out.println("\n=== Après modification 2 ===");
        System.out.println(v);
        
        v.accelerer(40.0f);
        v.tourner(-20.0f);
        System.out.println("\n=== Après modification 3 ===");
        System.out.println(v);
        
        caretaker.undo();
        System.out.println("\n=== Après undo ===");
        System.out.println(v);
        
        caretaker.undo();
        System.out.println("\n=== Après undo ===");
        System.out.println(v);
        
        caretaker.undo();
        System.out.println("\n=== Après undo ===");
        System.out.println(v);
        
        caretaker.undo();
        System.out.println("\n=== Après undo ===");
        System.out.println(v);
    }
}
