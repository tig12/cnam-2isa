/**
    Simple example of Composite pattern using vocabulary of GOF structure diagram
    Methods removeChild() and getChild() omitted because useless for this example.
    
    @author Thierry Graff
    @version 2017-12-19
**/

import java.util.List;
import java.util.ArrayList;

public class Sommateur {

    public static void main(String[] args) {
    
        Component root = new Composite();
        Component node1_1 = new Composite();
        Component node1_1_1 = new Nombre(12);
        Component node1_1_2 = new Nombre(14);
        Component node1_2 = new Composite();
        Component node1_2_1 = new Nombre(5);
        Component node1_2_2 = new Composite();
        Component node1_2_2_1 = new Nombre(3);
        Component node1_2_2_2 = new Nombre(6);
        
        root.addChild(node1_1);
        node1_1.addChild(node1_1_1);
        node1_1.addChild(node1_1_2);
        root.addChild(node1_2);
        node1_2.addChild(node1_2_1);
        node1_2.addChild(node1_2_2);
        node1_2_2.addChild(node1_2_2_1);
        node1_2_2.addChild(node1_2_2_2);

        // à compléter
        System.out.println("Somme totale = ");
        
        // Boucle affichant la somme de chaque enfant direct de la racine
        System.out.println("Somme des enfants : ");
        // à compléter
        
    }
}

abstract class Node {
    public abstract int somme();
    public void addChild(Node c){}
    public List<Node> getChildren(){
        return null;
    }
}

class Nombre extends Node{
    // A compléter
}

class Composite extends Node{
    
    private List<Node> children = new ArrayList<>();
    
    public int somme(){
        // à compléter
    }
    
    // composite stuff
    public List<Node> getChildren(){
        return children;
    }
    public void addChild(Node child){
        children.add(child);
    }
}

