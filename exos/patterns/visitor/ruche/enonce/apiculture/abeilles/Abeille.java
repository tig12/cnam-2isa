
package apiculture.abeilles;

import apiculture.ruche.Node;

/** 
    Visiteur abstrait
**/

public abstract class Abeille {
    
    protected String name;
    
    public Abeille(String name){ this.name = name; }
    
    public String getName(){ return name; }
    
    abstract public void visit(Node n);
}

