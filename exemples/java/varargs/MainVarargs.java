

/** 
    Pour tester si on peut utiliser les varargs dans main()
    (réponse = oui)
**/
public class MainVarargs{

    public static void main(String... args){
        System.out.println("MainVarargs - nb arguments : " + args.length);
        for(int i = 0; i < args.length; i++){
            System.out.println(i + " : " + args[i]);
        }
    }
    
}
