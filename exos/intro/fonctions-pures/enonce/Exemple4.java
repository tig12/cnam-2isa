import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Exemple4 {

    /** 
        Renvoie le contenu d'un fichier
        @param  path Chemin relatif ou absolu vers le fichier
    **/
    public static String lireFichier(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }
}


class Main4 {
    public static void main(String[] args){
        try{
            System.out.println(Exemple4.lireFichier("Exemple4.java"));
        }
        catch(Exception e){
            System.out.println("ERREUR : " + e.getMessage());
            System.out.println("Trace : ");
            e.printStackTrace();
        }
    }
    
}
