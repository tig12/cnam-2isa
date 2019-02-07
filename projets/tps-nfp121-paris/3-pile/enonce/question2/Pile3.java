package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

	private Vector<Object> v;

	public Pile3() {
		this(0);
	}

	public Pile3(int taille) {
		// traiter le cas <=0
		// à compléter
	}

	public void empiler(Object o) throws PilePleineException {
		// à compléter
	}

	public Object depiler() throws PileVideException {
		// à compléter
		return null;
	}

	public Object sommet() throws PileVideException {
		// à compléter
		return null;
	}

	public int taille() {
		// à compléter
		return -1;
	}

	public int capacite() {
		// à compléter
		return -1;
	}

	public boolean estVide() {
		// à compléter
		return false;
	}

	public boolean estPleine() {
		// à compléter
		return false;
	}

	public String toString() {
		// à compléter
		return "";
	}

	public boolean equals(Object o) {
		// à compléter
		return false;
	}

	// fonction fournie
	public int hashCode() {
		return toString().hashCode();
	}

}
