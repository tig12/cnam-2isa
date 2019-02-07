import java.io.File;
//import java.io.FilenameFilter;

/** 
    Filtre les fichiers se finissant par ".java" dans un répertoire
    en utilisant une lambda expression
**/
public class TestFilter4{
    public static void main(String[] args){
        File dir = new File(args[0]);
        String[] files = dir.list((f,s) -> { return s.endsWith(".java"); });
        for(String file : files){
            System.out.println(file);
        }
    }
}