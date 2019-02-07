import java.io.File;
import java.io.FilenameFilter;

/** 
    Filtre les fichiers se finissant par ".java" dans un répertoire
    avec classe FilenameFilter
    Même chose que Lambda2 mais avec une classe pas anonyme
**/
public class TestFilter3{
    public static void main(String[] args){
        File dir = new File(args[0]);
        String[] files = dir.list(new FilenameFilter() {
            public boolean accept(File f, String s) {
                return s.endsWith(".java");
            }
        });
        for(String file : files){
            System.out.println(file);
        }
    }
}