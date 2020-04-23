public class Parcelle{

    private String name;
    
    public Parcelle(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    public void ouvrirPorte(){
        System.out.println("Ouverture des portes de " + toString());
    }
    
    public void fermerPortes(){
        System.out.println("Fermeture des portes de " + toString());
    }

}
