import java.io.File;
import java.io.FilenameFilter;

/** 
    Filtre les fichiers se finissant par ".java" dans un répertoire
    en utilisant <code>public String[] list(FilenameFilter filter)</code>
**/
public class TestFilter2{
    public static void main(String[] args){
        File dir = new File(args[0]);
        String[] files = dir.list(new JavaFilenameFilter());
        for(String file : files){
            System.out.println(file);
        }
    }
}

class JavaFilenameFilter implements FilenameFilter{
    public boolean accept(File f, String s) {
        return s.endsWith(".java");
    }
}