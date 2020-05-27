enum CouleurPrimaire {
    ROUGE, VERT, BLEU
}

class TestEnum1{
    public static void main(String[] args) {
        System.out.println("Rouge = " + CouleurPrimaire.ROUGE);
        // 
        CouleurPrimaire cp = CouleurPrimaire.ROUGE;
        System.out.println("cp = " + cp);
        
        // la ligne suivante ne passe pas à la compilation
        // if(cp == ROUGE) System.out.println("cp est bien rouge");
        if(cp == CouleurPrimaire.ROUGE) System.out.println("cp est bien rouge");
        
        if(cp.name() == "ROUGE") System.out.println("cp.name() = ROUGE");
        
        switch(cp){
            case ROUGE :
                System.out.println("cp est ROUGE");
            break;  
            case BLEU :
                System.out.println("cp est BLEU");
            break;  
            case VERT :
                System.out.println("cp est VERT");
            break;  

        }
    }
}
