public class Serre{

    private String name;
    
    private Thermometre thermometre;
    
    public Serre(String name){
        this.name = name;
    }
    
    public void setThermometre(Thermometre t){
        thermometre = t;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    public void ouvrirFenetres(){
        System.out.println("Ouverture des fenêtres de " + toString());
    }
    
    public void fermerFenetres(){
        System.out.println("Fermeture des fenêtres de " + toString());
    }
    
    public void ouvrirPorte(){
        System.out.println("Ouverture des portes de " + toString());
    }
    
    public void fermerPortes(){
        System.out.println("Fermeture des portes de " + toString());
    }
}
