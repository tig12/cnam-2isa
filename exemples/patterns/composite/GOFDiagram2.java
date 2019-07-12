/**
    Simple example of Composite pattern using vocabulary of GOF structure diagram
    Methods remove() and getChild() omitted because useless for this example.
    
    Version qui n'a qu'une classe : Component, car Leaf et Composite ne fait rien de plus
    
    @author Thierry Graff
    @version 2017-12-19
**/

import java.util.List;
import java.util.ArrayList;

public class GOFDiagram2 {

    public static void main(String[] args) {
    
        Component root = new Component("root");
        Component node1_1 = new Component("  Component 1.1");
        Component node1_1_1 = new Component("    leaf 1.1.1");
        Component node1_1_2 = new Component("    leaf 1.1.2");
        Component node1_2 = new Component("  Component 1.2");
        Component node1_2_1 = new Component("    leaf 1.2.1");
        Component node1_2_2 = new Component("    Component 1.2.2");
        Component node1_2_2_1 = new Component("      leaf 1.2.2.1");
        Component node1_2_2_2 = new Component("      leaf 1.2.2.2");
        
        root.addChild(node1_1);
        node1_1.addChild(node1_1_1);
        node1_1.addChild(node1_1_2);
        root.addChild(node1_2);
        node1_2.addChild(node1_2_1);
        node1_2.addChild(node1_2_2);
        node1_2_2.addChild(node1_2_2_1);
        node1_2_2.addChild(node1_2_2_2);
        
        root.operation();
    }
}

class Component{
    
    private String name;
    
    private List<Component> children = new ArrayList<>();
    
    public Component(String name){ this.name = name; }
    
    public void operation(){
        System.out.println(name);
        for(Component child : children){
            child.operation();
        }
    }
    
    public void addChild(Component child){
        children.add(child);
    }
}

