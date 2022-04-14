
class ExterieurDemo4 {
    
    static int i1;  // variable de classe
    int i2;         // variable d'instance
    
    public static void main(String args[]) {
        // test pour variable de classe
        Runnable r = () -> System.out.println("i1 = " + i1);
        i1 = 5;
        r.run();
        i1 = 6;
        r.run();
        
        // test pour variable d'instance
        ExterieurDemo3 test = new ExterieurDemo3();
        test.instanceMethod();
        test.i2 = 3;
        test.instanceMethod();
    }
    
    void instanceMethod(){
        Runnable r = () -> System.out.println("i2 = " + i2);
        r.run();
    }
}
