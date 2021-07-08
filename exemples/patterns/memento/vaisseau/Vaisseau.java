
/** 
    Représente un vaisseau spatial
    "Originator" dans le pattern Memento.
    Le memento n'enregistre que la vitesse et la direction
**/
public class Vaisseau {
    
    /**
        Pourcentage de fuel restant (entre 0 et 100).
        Cette caractéristique n'est pas mémorisée par le memento.
    **/
    private float pourcentFuel;
    
    /**  Direction du vaisseau, entre 0 et 360. **/ 
    private float direction;
    
    /**  Vitesse du vaisseau **/
    private float vitesse;
 
    public Vaisseau(){
        pourcentFuel = 100.0f;
        vitesse = 0.0f;
        direction = 0.0f;
    }
    
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Vitesse = ")
            .append(Float.toString(vitesse))
            .append(" ; Direction = ")
            .append(Float.toString(direction))
            .append(" ; Fuel = ")
            .append(Float.toString(pourcentFuel))
            .append(" %");
        return res.toString();
    }
    
    // === Pilotage du vaisseau ===
    
    /** Freine ou accélère le vaisseau **/
    public void accelerer(float valeur){
        vitesse += valeur;
        if(vitesse < 0.0f){
            vitesse = 0.0f;
            pourcentFuel--;
        }
    }
    
    /** Change la direction du vaisseau **/
    public void tourner(float valeur){
        direction += valeur;
        while(direction < 0){
            direction += 360.0f;
        }
        direction = direction % 360.0f;
        pourcentFuel--;
    }
    
    
    // == Memento management ===
    
    public Memento enregistreEtat() {
        return new Memento(direction, vitesse);
    }
 
    public void restoreEtat(Memento memento) {
        this.vitesse = memento.getVitesse();
        this.direction = memento.getDirection();
    }
 

    // === Memento : classe interne du vaisseau ===
    
    public static class Memento {
        private float direction;
        private float vitesse;
 
        private Memento(float direction, float vitesse) {
            this.direction = direction;
            this.vitesse = vitesse;
        }
 
        private float getVitesse() { return vitesse; }
        private float getDirection() { return direction; }
    }
    

}
