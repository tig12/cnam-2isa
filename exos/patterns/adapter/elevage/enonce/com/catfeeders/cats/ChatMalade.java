package com.catfeeders.cats;
import com.catfeeders.CatFeederEntity;

public class ChatMalade extends CatFeederEntity {

    private String nom;
    
    public ChatMalade(String nom){
        this.nom = nom;
    }
    
    public void donnerNourritureEtMedicaments(){
        System.out.println(nom + " : donner des croquettes et des médicaments");
    }
}
