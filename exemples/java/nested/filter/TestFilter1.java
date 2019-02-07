import java.io.File;

/** 
    Filtre les fichiers se finissant par ".java" dans un répertoire
    boucle classique
**/
public class TestFilter1{
    public static void main(String[] args){
        File dir = new File(args[0]);
        String[] files = dir.list();
        for(String file : files){
            if(file.endsWith(".java")){
                System.out.println(file);
            }
        }
    }
}