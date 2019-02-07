import java.io.*;

class InputStreamExample{
    
    public static void main(String[] args){
        try (InputStream is = new FileInputStream("test.txt")) {
        byte[] buf = new byte[4096];
        int len, count = 0;
        while ((len = is.read(buf)) > 0) {
            for (int i=0; i<len; i++)
                if (buf[i] == 97) count++;
        }
            System.out.println("Trouvé "+ count + " 'a'");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}