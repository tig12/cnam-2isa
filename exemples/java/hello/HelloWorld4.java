class HelloWorld4 {
    
    public static void main(String[] args) {
        Afficheur.afficher(args[0]);
    }
    
}

class Afficheur{
 
    public static void afficher(String msg) {
        System.out.println(msg);
    }
    
}
