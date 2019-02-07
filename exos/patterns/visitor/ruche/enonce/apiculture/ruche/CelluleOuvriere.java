
package apiculture.ruche;

import apiculture.abeilles.Abeille;

/** 
    Cellule utilisée pour élever une abeille ouvrière
    Noeud terminal de la structure composite
**/
public class CelluleOuvriere extends Node {

    public CelluleOuvriere(String name){ super(name); }
    
    public void accept(Abeille a){
        a.visit(this);
    }
}

