
package apiculture.ruche;

import apiculture.abeilles.Abeille;

/** 
    Cellule utilisée pour élever une abeille reine
    Noeud terminal de la structure composite
**/
public class CelluleRoyale extends Node {
    
    public CelluleRoyale(String name){ super(name); }
    
    public void accept(Abeille a){
        a.visit(this);
    }
}



