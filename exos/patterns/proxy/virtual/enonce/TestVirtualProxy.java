
class TestVirtualProxy{
    
    public static void main(String[] args) {
        
        System.out.println("dans main() : avant instanciation de GrosObjet");
        GrosObjet go = new GrosObjet();
        System.out.println("dans main() : après instanciation de GrosObjet");
        
        System.out.println();
        System.out.println("dans main() : appel à go.méthodeAyantVraimentBesoinDeGrosObjet()");
        go.premièreMéthodeAyantVraimentBesoinDeGrosObjet();
        System.out.println("dans main() : appel à go.secondeMéthodeAyantVraimentBesoinDeGrosObjet()");
        go.secondeMéthodeAyantVraimentBesoinDeGrosObjet();
    }
}

/** 
    Interface commune à GrosObjet et GrosObjetProxy
**/
interface IGrosObjet{
    // à compléter
}

/**
    Proxy se substituant à GrosObjet pour implémenter le lazy loading
**/
class GrosObjetProxy{
    // à compléter
}

class GrosObjet{

    public GrosObjet(){
        System.out.println("    constructeur GrosObjet === Création très chère ===");
    }
    
    public void premièreMéthodeAyantVraimentBesoinDeGrosObjet(){
        System.out.println("    premièreMéthodeAyantVraimentBesoinDeGrosObjet()");
    }
    
    public void secondeMéthodeAyantVraimentBesoinDeGrosObjet(){
        System.out.println("    secondeMéthodeAyantVraimentBesoinDeGrosObjet()");
    }
    
}

