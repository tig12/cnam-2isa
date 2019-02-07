
public class Varargs{

    public static void main(String[] args){
        System.out.println("somme = " + somme(3, 8, 19, 3, 2));
    }
    
    public static int somme(int premier, int... autres){
        int somme = premier;
        for(int i : autres) {
            somme += i;
        }
        return somme;
    }

}
