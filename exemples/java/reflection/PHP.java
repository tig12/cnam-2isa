

/** 
    Tests sur les équivalent php
**/
public class PHP{
    
    public static void main(String[] args){
        printLine();
        
    }
    
    /** Equivalent de __LINE__ **/
    private static void printLine(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
    }
    
}
