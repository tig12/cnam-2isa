
import java.util.List;
import java.util.ArrayList;

/** 
    Stocke les différents objets mementos.
    "Caretaker" dans le pattern Memento.
**/
class VaisseauCaretaker {
    
    private List<Vaisseau.Memento> savedStates;
    
    /** Le vaisseau dont ce caretaker s'occupe **/
    private Vaisseau v;
    
    public VaisseauCaretaker(Vaisseau v) {
        this.v = v;
        savedStates = new ArrayList<Vaisseau.Memento>();
    }
    
    public void saveState(){
        savedStates.add(v.enregistreEtat());
    }
    
    public void undo(){
        int size = savedStates.size();
        if(size == 0){
            return; // pourrait lancer une exception
        }
        // remove() renvoie et supprime l'élément
        v.restoreEtat(savedStates.remove(size - 1));
    }
    
}
