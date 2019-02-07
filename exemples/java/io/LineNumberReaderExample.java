
// code dans exemples/nio utilisé pour la page sur pattern decorator

import java.io.*;

class LineNumberReaderExample{
    
    public static void main(String[] args){
        try{
            LineNumberReader lnr = new LineNumberReader(new BufferedReader(new FileReader("test.txt")));
            //LineNumberReader lnr = new LineNumberReader(new FileReader("test.txt"));
            String curLine = "";
            int lNum = 0;
            while((curLine = lnr.readLine()) != null){
                 lNum =  lnr.getLineNumber();                 
                 System.out.println(lNum +"\t     "+ curLine);
             }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}