
public class Main{

    public static void main(String[] args) throws CustomException{
        Compteur c = new Compteur(3);
        c.ajoute(4);
        c.affiche();
    }
}