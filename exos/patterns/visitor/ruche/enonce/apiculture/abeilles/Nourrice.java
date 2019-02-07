
package apiculture.abeilles;

import apiculture.ruche.Node;

/** 
    Visiteur concret
**/

public class Nourrice extends Abeille {
    
    public Nourrice(String name){ super(name); }
    
    public void visit(Node n){
        System.out.println("Visite de " + n.getName() + " par " + this.getName());
    }
    
}

