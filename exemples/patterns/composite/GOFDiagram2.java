/**
    Same output as GOFDiagram1 with a different implementation :
    Component names are not preceeded by white spaces.
    Preceeding white spaces are computed using getLevel().
    getLevel() needs a reference to parent node, so class Component
    contains a field parent and methods getParent() and setParent().
    The implementation of operation() is now in Component class,
    used by Leaf and by Composite
    
    @author Thierry Graff
    @version 2017-12-19
**/

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GOFDiagram2 {

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
    protected Component parent = null;
    
    public Component(String name){ this.name = name; }
    
    public void operation(){
        System.out.println(String.join("", Collections.nCopies(getLevel(), "  ")) + name);
    }
    
    public void addChild(Component c){}
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
    
    public void operation(){
        super.operation();
        for(Component child : children){
            child.operation();
        }
    }
    
    public void addChild(Component child){
        children.add(child);
        child.setParent(this);
    }
}

