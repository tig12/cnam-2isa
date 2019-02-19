package question3;

import question1.PilePleineException;
import question1.PileVideException;

public interface PileI<T> {

    public final static int CAPACITE_PAR_DEFAUT = 6;

    public void empiler(T o) throws PilePleineException;
    public T depiler() throws PileVideException;
    
    public T sommet() throws PileVideException;
    public int capacite();
    public int taille();
    public boolean estVide();
    public boolean estPleine();
    public boolean equals(Object o);
    public int hashCode();
    public String toString();

}