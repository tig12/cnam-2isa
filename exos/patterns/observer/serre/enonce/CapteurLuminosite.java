public class CapteurLuminosite{

    private String name;

    public CapteurLuminosite(String name){
        this.name = name;
    }
    
    /** 
        Renvoie la luminosité mesurée par le capteur, en lux.
        Note : un vrai capteur devrait renvoyer une valeur ne dépendant pas de l'heure de la mesure.
        Mais cela n'a aucune importance dans le cadre de cet exercice.
    **/
    public double getLuminosite(int minutes){
        double m = (double)minutes;
        // avant 5 h et apres 19 h, luminosite = 0
        if(m < 300 || m > 1140){
            return 0.0;
        }
        // entre 6h et 12h, renvoie une luminosité croisante, allant de 0 à 50 000 lux.
        if(m >= 300 && m <= 720){
            return 119.04761904761904761905 * m - 33900.0;
        }
        // entre 12 h et 19 h, renvoie une luminosité décroissante, allant de 50 000 à 0 lux.
        return -119.04761904761904761905 * m + 135714.285714285714285717;
    }
}