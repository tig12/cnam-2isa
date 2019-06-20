package com.catfeeders.cats;
import com.catfeeders.CatFeederEntity;

public class ChatVorace extends CatFeederEntity {

    private String nom;
    
    public ChatVorace(String nom){
        this.nom = nom;
    }
    
    public void alimenterAvecParcimonie(){
        System.out.println(nom + " : donner en 5 fois 20% de sa dose journalière");
    }
}
