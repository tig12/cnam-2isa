/** 
    Premier test d'implémentation du pattern Observer
**/
class Main{
    
    public static void main(String[] args){

        // create observable
        DataHolder data = new DataHolder();
        data.changeState("a", 50.0);
        data.changeState("b", 30.0);
        data.changeState("c", 20.0);
        
        // create observers
        Bar o1 = new Bar(data);
        Pie o2 = new Pie(data);
        Grid o3 = new Grid(data);

        System.out.println("=== Affichage état initial ===");
        o1.print();
        o2.print();
        o3.print();
        
        data.changeState("b", 35.0);
        data.changeState("c", 15.0);
        
        System.out.println("=== Affichage état modifié ===");
        o1.print();
        o2.print();
        o3.print();
        
    }
}