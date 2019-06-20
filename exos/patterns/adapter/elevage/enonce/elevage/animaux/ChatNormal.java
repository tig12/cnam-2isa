package elevage.animaux;

public class ChatNormal {

    private String nom;
    
    public ChatNormal(String nom){
        this.nom = nom;
    }
    
    public void alimenter(){
        System.out.println(nom + " : donner des croquettes à volonté");
    }
}
