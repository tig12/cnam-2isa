import static java.lang.System.out;

class Main{
    
    public static void main(String[] args){
        
        out.println("==== tests static ====");
        Class1.printStatic();
        Class1.ClasseInterneStatic.printStatic();
        
        out.println("\n==== tests instance ====");
        Class1 c1 = new Class1();
        Class1.ClasseInterne interne1 = c1.new ClasseInterne();
        c1.printInstance();
        interne1.printInstance();
        
    }
    
}