import java.io.*;
import java.net.*;

class RemoteExample{
    
    public static void main(String[] args){
        URL url = null;
        try{
            url = new URL("https://larzac.info/cnam/index.html");
        }
        catch(MalformedURLException e){
            e.printStackTrace();
        }
        try(
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        ){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
