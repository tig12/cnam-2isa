package question1;

public class PolygoneRegulier {

    private int nombreDeCotes;
    private int longueurDuCote;

    /**
     * Création d'un polygone régulier
     * 
     * @param nombreDeCotes
     *            (nombreDeCotes >=1 && nombreDeCotes <100)
     * @param longueurDuCote
     *            (longueurDuCote>=1 && longueurDuCote < 10000)
     */
    public PolygoneRegulier(int nombreDeCotes, int longueurDuCote) {
        assert nombreDeCotes >= 1 && nombreDeCotes < 100;
        assert longueurDuCote >= 1 && longueurDuCote < 10000;
        this.nombreDeCotes = nombreDeCotes;
        this.longueurDuCote = longueurDuCote;
    }

    public int perimetre() {
        return nombreDeCotes * longueurDuCote;
    }

    public int surface() {
        return (int) (1 / 4.0 * nombreDeCotes * Math.pow(longueurDuCote, 2.0) * cotg(Math.PI
                / nombreDeCotes));
    }

    private static double cotg(double x) {
        return Math.cos(x) / Math.sin(x);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PolygoneRegulier)) {
            return false;
        } else {
            PolygoneRegulier poly = (PolygoneRegulier) obj;
            return poly.nombreDeCotes == nombreDeCotes
            && poly.longueurDuCote == longueurDuCote;
        }
    }

    public int hashCode() {
        return nombreDeCotes * 10000 + longueurDuCote;
        // ou bien return toString().hashCode(); // ou
    }

    public String toString() {
        return "<" + nombreDeCotes + "," + longueurDuCote + ">";
    }
}
