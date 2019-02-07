
package apiculture.ruche;

import apiculture.abeilles.Abeille;

/** 
    Cellule utilisée pour élever une abeille mâle (faux bourdon)
    Noeud terminal de la structure composite
**/
public class CelluleMale extends Node {

    public CelluleMale(String name){ super(name); }

    public void accept(Abeille a){
        a.visit(this);
    }
}



