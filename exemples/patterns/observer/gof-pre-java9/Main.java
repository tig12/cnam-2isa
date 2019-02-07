/** 
    Premier test d'implémentation du pattern Observer
**/
class Main{
    
    public static void main(String[] args){

        // create observers
        Bar o1 = new Bar();
        Pie o2 = new Pie();
        Grid o3 = new Grid();

        // create observable
        Data data = new Data();
        
        // attach observers to to data
        data.addObserver(o1);
        data.addObserver(o2);
        data.addObserver(o3);
        
        // test notify 1
        // rien ne se passe, car aucun modif sur les données
        System.out.println(" ==== test notify 1 ====");
        data.notifyObservers();
        
        // test notify 2
        // notifyObservers() appelé après un changeState()
        // la méthode update() des observers est appelée
        System.out.println(" ==== test notify 2 ====");
        // data.setChanged(); // NON car setChanged() protected,
        // donc utilisable que dans les sous-classes de Observable
        data.changeState();
        data.notifyObservers();
        
        // test notify 3
        // notifyObservers() appelé avec un paramètre après un changeState()
        // la méthode update() des observers est appelée
        System.out.println(" ==== test notify 3 ====");
        data.changeState();
        data.notifyObservers("Description du changement");
    }
}