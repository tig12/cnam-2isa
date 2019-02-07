/**
    Simple example of Composite pattern using vocabulary of GOF structure diagram
    Methods remove() and getChild() omitted because useless for this example.
    
    @author Thierry Graff
    @version 2017-12-19
**/

import java.util.List;
import java.util.ArrayList;

public class GOFDiagram1 {

    public static void main(String[] args) {
    
        Component root = new Composite("root");
        Component node1_1 = new Composite("  composite 1.1");
        Component node1_1_1 = new Leaf("    leaf 1.1.1");
        Component node1_1_2 = new Leaf("    leaf 1.1.2");
        Component node1_2 = new Composite("  composite 1.2");
        Component node1_2_1 = new Leaf("    leaf 1.2.1");
        Component node1_2_2 = new Composite("    composite 1.2.2");
        Component node1_2_2_1 = new Leaf("      leaf 1.2.2.1");
        Component node1_2_2_2 = new Leaf("      leaf 1.2.2.2");
        
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

abstract class Component {
    protected String name;
    
    public Component(String name){ this.name = name; }
    
    public abstract void operation();
    
    public abstract void addChild(Component c);
}

class Leaf extends Component{
    
    public Leaf(String name){ super(name); }
    
    public void operation(){
        System.out.println(name);
    }
    
    public void addChild(Component c){ }
}

class Composite extends Component{
    
    private List<Component> children = new ArrayList<>();
    
    public Composite(String name){ super(name); }
    
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

