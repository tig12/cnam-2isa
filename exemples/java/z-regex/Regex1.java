

// PAS FINI

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Regex1 {

    public static void main(String argv[]) {
        try{
            String text = new String(Files.readAllBytes(Paths.get("texte1.txt")));
            Pattern p = Pattern.compile("^[a-c].*"); // lignes commençant par a, b ou c
            Matcher m = p.matcher(text);
            while (m.find()) {
                System.out.println("I found the text " + m.group());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}