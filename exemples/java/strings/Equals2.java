/** 
    Contre-exemple : en général, == et equals() se comportent différement
    Mais ici, optimisation du compilateur, s1 et s2 pointent vers le même objet, donc == "marche"
**/
public class Equals2{
    public static void main(String[] args){
        String s1 = "azerty";
        String s2 = "azerty";
        System.out.println("s1 == s2 : " + (s1 == s2) );
    }
}
