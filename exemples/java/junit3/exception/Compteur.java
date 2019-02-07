
public class Compteur{

    private int compte = 0;
    
    public Compteur(){
    }
    
    public Compteur(int n) throws CustomException{
        if(n < 0){
            throw new CustomException();
        }
        compte = n;
    }
    
    public void ajoute(int n) throws CustomException{
        if(n < 0){
            throw new CustomException();
        }
        compte += n;
    }
    
    public int getCompte(){
        return compte;
    }
    
    public void affiche() throws CustomException{
        System.out.println("compteur = " + compte);
    }
}