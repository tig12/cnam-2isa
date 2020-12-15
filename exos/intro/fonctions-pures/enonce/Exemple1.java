
class Exemple1 {

    private static int a = 0;
    
    public static int incrementer(){
        a = a + 1;
        return a;
    }
}

class Exemple1Bis {

    public static int incrementer(int a){
        a = a + 1;
        return a;
    }
}


class Main1 {
    
    public static void main(String[] args){
        System.out.println("=== exemple 1 ===");
        System.out.println("  appel incrementer()");
        System.out.println("  a = " + Exemple1.incrementer());
        System.out.println("  appel incrementer()");
        System.out.println("  a = " + Exemple1.incrementer());
        System.out.println("  appel incrementer()");
        System.out.println("  a = " + Exemple1.incrementer());
        
        System.out.println("=== exemple 1bis ===");
        System.out.println("  appel incrementer(1)");
        System.out.println("  a = " + Exemple1Bis.incrementer(1));
        System.out.println("  appel incrementer(1)");
        System.out.println("  a = " + Exemple1Bis.incrementer(1));
        System.out.println("  appel incrementer(1)");
        System.out.println("  a = " + Exemple1Bis.incrementer(1));
    }
    
}
