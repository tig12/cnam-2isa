
package apiculture.ruche;

import java.util.List;
import java.util.ArrayList;

import apiculture.abeilles.Abeille;

/** 
    Super-classe de Ruche et Rayon
**/

public class Composed extends Node{
    
    protected List<Node> children = new ArrayList<>();
    
    public Composed(String name){ super(name); }
    
    public void addChild(Node n){
        children.add(n);
    }
    
    // visitor stuff
    public void accept(Abeille a){
        for(Node child : children){
            child.accept(a);
        }
    }
}



