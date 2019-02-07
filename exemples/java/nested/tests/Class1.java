import static java.lang.System.out;

class Class1{
    
    // ***** static *****
    
    private static int a = 1;
    private static int b = 2;
    public static void printStatic(){
        out.println("Class1.printStatic(), a = " + a);
    }
    
    public static class ClasseInterneStatic{
        private static int a = 3;
        public static void printStatic(){
            out.println("ClasseInterneStatic.printStatic(), a = " + a);
            out.println("ClasseInterneStatic.printStatic(), Class1.a = " + Class1.a);
            out.println("ClasseInterneStatic.printStatic(), b = " + b);
        }
    }
    
    // ***** instance *****
    
    private int c = 4;
    private int d = 5;
    public void printInstance(){
        out.println("Class1.printInstance(), c = " + this.c);
    }
    
    public class ClasseInterne{
        private int c = 6;
        public void printInstance(){
            out.println("ClasseInterne.printInstance(), c = " + c);
            out.println("ClasseInterne.printInstance(), this.c = " + this.c);
            out.println("ClasseInterne.printInstance(), Class1.this.c = " + Class1.this.c); // syntaxe spéciale
            out.println("ClasseInterne.printInstance(), d = " + d);
        }
        // public static int e = 7;                 // IMPOSSIBLE
        // public static void printStatic(){ }      // IMPOSSIBLE
    }
    
}