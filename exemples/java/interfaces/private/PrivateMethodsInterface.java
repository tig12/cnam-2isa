
/** 
    Illustre l'utilisation de méthodes privées dans les interfaces
**/

interface PrivateMethodsInterface {
    
    void methodeAImplementer();
    
    default void method1(){
        System.out.println("Interface1.method1(), qui va appeler privateMethod()");
        privateMethod();
    }
    
    private void privateMethod(){
        System.out.println("Interface1.privateMethod()");
    }
}


/** 
    On voit que C1 implémente PrivateMethodsInterface sans avoir eu besoin d'implémenter PrivateMethodsInterface.privateMethod()
    C1 récupère l'implémentation de method1(), en bénéficiant de privateMethod()
**/
class C1 implements PrivateMethodsInterface{

    public static void main(String[] arg){
        System.out.println("=== dans main() ===");
        C1 c1 = new C1();
        c1.method1();
    }
    
    // Implémentation de PrivateMethodsInterface
    public void methodeAImplementer(){
        System.out.println("Implémentation de methodeAImplementer()");
    }
}

