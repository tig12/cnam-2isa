

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Suppression {

    public static void main(String[] args) {
    
        Component root = new Composite("root");
        Component node1_1 = new Composite("composite 1.1");
        Component node1_1_1 = new Leaf("leaf 1.1.1");
        Component node1_1_2 = new Leaf("leaf 1.1.2");
        Component node1_2 = new Composite("composite 1.2");
        Component node1_2_1 = new Leaf("leaf 1.2.1");
        Component node1_2_2 = new Composite("composite 1.2.2");
        Component node1_2_2_1 = new Leaf("leaf 1.2.2.1");
        Component node1_2_2_2 = new Leaf("leaf 1.2.2.2");
        
        root.add(node1_1);
        node1_1.add(node1_1_1);
        node1_1.add(node1_1_2);
        
        root.add(node1_2);
        node1_2.add(node1_2_1);
        node1_2.add(node1_2_2);
        node1_2_2.add(node1_2_2_1);
        node1_2_2.add(node1_2_2_2);
        
        // node1_2 ajouté une seconde fois
        root.add(node1_2);
        node1_2.add(node1_2_1);
        
        root.print();
    }
}

abstract class Component {
    protected String name;
    protected Component parent = null;
    
    public Component(String name){ this.name = name; }
    
    public void print(){
        System.out.println(String.join("", Collections.nCopies(getLevel(), "  ")) + name);
    }
    
    public void add(Component c){}
    public Component getParent(){ return parent; }
    public void setParent(Component parent){ this.parent = parent; }
    
    public int getLevel(){ return parent == null ? 0 : parent.getLevel() + 1; }
}

class Leaf extends Component{
    public Leaf(String name){ super(name); }
}

class Composite extends Component{
    
    private List<Component> children = new ArrayList<>();
    
    public Composite(String name){ super(name); }
    
    public void print(){
        super.print();
        for(Component child : children){
            child.print();
        }
    }
    
    public void add(Component child){
        children.add(child);
        child.setParent(this);
    }
}

