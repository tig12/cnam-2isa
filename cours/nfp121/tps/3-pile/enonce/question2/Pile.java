package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
    }

    public Object depiler() throws PileVideException {
        // a completer
        return null;
    }

    public Object sommet() throws PileVideException {
        // a completer
        return null;
    }

    public int capacite() {
        // a completer
        return -1;
    }

    public int taille() {
        // a completer
        return -1;
    }

    public boolean estVide() {
        // a completer
        return false;
    }

    public boolean estPleine() {
        // a completer
        return false;
    }

    public boolean equals(Object o) {
        // a completer
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        // a completer
        return null;
    }
}