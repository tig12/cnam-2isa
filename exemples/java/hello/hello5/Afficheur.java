class Afficheur{
 
    /** Le message à afficher **/
    private String msg;
    
    public Afficheur(String message){
        msg = message;
    }
    
    public void afficher(){
        System.out.println(msg);
    }
}
