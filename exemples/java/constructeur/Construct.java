/** 
    Teste les conversions implicites effectuées lors de l'appel de this().
    Pour tester, commenter les différents constructeurs et recompiler, 
    pour voir lequel est appelé
**/
class Construct {
    
    public static void main(String[] args) {
        Test t1 = new Test();
    }
    
    public Test(){
        this(1);
        //this(1.0);
        //this(1F);
    }
    public Test(int x){
        System.out.println("Constructeur(int)");
    }
    public Test(double x){
        System.out.println("Constructeur(double)");
    }
    public Test(float x){
        System.out.println("Constructeur(float)");
    }
}
