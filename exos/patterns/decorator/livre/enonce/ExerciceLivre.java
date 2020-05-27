
interface LivreI{
    public void afficherInfos();
}

class Livre implements LivreI {
    public void afficherInfos(){
        System.out.print("Livre");
    }
}
class LivreAvecReliure implements LivreI {
    public void afficherInfos(){
        System.out.print("Livre avec reliure");
    }
}
class LivreAvecMarquePage implements LivreI {
    public void afficherInfos(){
        System.out.print("Livre avec marque-page");
    }
}
class LivreAvecReliureEtMarquePage implements LivreI {
    public void afficherInfos(){
        System.out.print("Livre avec reliure avec marque-page");
    }
}
class LivreAvecMarquePageEtReliure implements LivreI {
    public void afficherInfos(){
        System.out.print("Livre avec marque-page avec reliure");
    }
}


/** Code client **/
public class ExerciceLivre{
    public static void main(String[] args){
        LivreI l1 = new Livre();
        l1.afficherInfos();
        
        System.out.println();
        LivreI l2 = new LivreAvecReliure();
        l2.afficherInfos();
                                        
        System.out.println();
        LivreI l3 = new LivreAvecMarquePage();
        l3.afficherInfos();
        
        System.out.println();
        LivreI l4 = new LivreAvecReliureEtMarquePage();
        l4.afficherInfos();
        
        System.out.println();
        LivreI l5 = new LivreAvecMarquePageEtReliure();
        l5.afficherInfos();
        
        System.out.println();
    }
}
