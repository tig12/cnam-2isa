

public class Main{
    
    public static void main(String[] args){
        System.out.println("=== Préparation d'un repas ===");
        preparerRepas();
    }
    
    public static void preparerRepas(){
        Salade s = new Salade();
        OeufAuPlat o = new OeufAuPlat();
        Riz r = new Riz();
        Kiwi k = new Kiwi();
        
        s.preparer();
        o.cuire();
        r.faireCuire();
        k.eplucher();
    }
    
}

