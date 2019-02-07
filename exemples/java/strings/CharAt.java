/** 
    Illustre le fait qu'une String ne peut être utilisée comme un tableau.
**/
public class CharAt{

    public static void main(String[] args){
        String s2 = "une chaîne de caractères";
        
        // les lignes suivantes ne passent pas à la compilation
        // for(int i=0; i < s2.length; i++){
        //     System.out.println(s2[i]);
        // }
        
        // la syntaxe correcte est
        for(int i=0; i < s2.length(); i++){
            System.out.println(s2.charAt(i));
        }
        
    }

}
