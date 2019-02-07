import java.io.*;

class BufferedReaderExample{
    
    public static void main(String[] args){
        try (BufferedReader in = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) { }
    }
}