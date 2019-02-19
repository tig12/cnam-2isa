package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacité;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        // à compléter
    }

    public Pile2(){
        // à compléter
    }

    public void empiler(T o) throws PilePleineException{
        // à compléter
    }

    public T depiler() throws PileVideException{
        // à compléter
    }

    public T sommet() throws PileVideException{
        // à compléter
    }

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2