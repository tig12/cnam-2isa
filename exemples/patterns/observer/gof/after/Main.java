/** 
    Une implémentation du pattern Observer, d'après le schéma gof.
**/
class Main{
    
    public static void main(String[] args){

        // create observable
        DataHolder dataHolder = new DataHolder();
        
        // create observers
        Bar o1 = new Bar();
        Pie o2 = new Pie();
        Grid o3 = new Grid();
        
        dataHolder.setState("a", 50.0);
        dataHolder.setState("b", 30.0);
        dataHolder.setState("c", 20.0);

        // attach observers to observable
        dataHolder.attach(o1);
        dataHolder.attach(o2);
        dataHolder.attach(o3);
        
        System.out.println("--------- 1 ---------");
        o1.print();
        o2.print();                                                                                  
        o3.print();
        
        System.out.println("--------- 2 ---------");
        dataHolder.setState("a", 50.0);
        dataHolder.setState("b", 30.0);
        dataHolder.setState("c", 20.0);
        o1.print();
        o2.print();
        o3.print();
        
        System.out.println("--------- 3 ---------");
        dataHolder.setState("b", 35.0);
        dataHolder.setState("c", 15.0);
        o1.print();
        o2.print();
        o3.print();
        
    }
}