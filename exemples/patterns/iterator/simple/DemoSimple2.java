

// =========== 1 - Aggrégat ===========

/** 
    Implémentation d'un itérateur simple.
    Répond à la demande de pouvoir itérer avec un objet distinct de l'aggrégat,
    mais ne correspond pas au pattern Iterator car n'implémente pas les notions
    d'itérateur abstrait et d'aggrégat abstrait.
    
    Même chose que DemoSimple mais les itérateurs ne sont pas des classes internes
    => on doit rajouter ArrayAggregate.getData()
    
    Illustre le fait qu'un aggrégat doit exposer certains aspects de son intérieur pour
    permettre à des itérateurs extérieurs d'itérer.
    
**/
class ArrayAggregate {
    
    private Object[] data;
    
    public ArrayAggregate(Object[] data){
        this.data = data;
    }
    
    public NormalIterator getNormalIterator() {
        return new NormalIterator(this);
    }
    
    public ReverseIterator getReverseIterator() {
        return new ReverseIterator(this);
    }
    
    public Object[] getData(){
        return data;
    }
    
}

// =========== 2 - Itérateurs ===========

/** 
    Itérateur pour parcourir un ArrayAggregate
**/
class NormalIterator {
    
    /** L'aggrégat parcouru par cet itérateur **/
    private ArrayAggregate aa;
    
    /** Index courant de l'itération **/
    private int index;
    
    public NormalIterator(ArrayAggregate aa){
        this.aa = aa;
        this.index = -1;
    }
    
    /** 
        Renvoie l'élément courant et avance la position de l'itération
    **/
    public Object next() {
        index++;
        return aa.getData()[index];
    }
    
    /** 
        Indique s'il reste des éléments à parcourir
    **/
    public boolean hasNext() {
        return index < aa.getData().length - 1;
    }
}

/** 
    Itérateur pour parcourir un ArrayAggregate en sens inverse
**/
class ReverseIterator {
    
    /** L'aggrégat parcouru par cet itérateur **/
    private ArrayAggregate aa;
    
    /** Index courant de l'itération **/
    private int index;
    
    public ReverseIterator(ArrayAggregate aa){
        this.aa = aa;
        this.index = aa.getData().length;
    }
    
    /** 
        Renvoie l'élément courant et avance la position de l'itération
    **/
    public Object next() {
        index--;
        return aa.getData()[index];
    }
    
    /** 
        Indique s'il reste des éléments à parcourir
    **/
    public boolean hasNext() {
        return index > 0;
    }
}

// =========== 3 - Code client ===========

public class DemoSimple2{
    
    public static void main(String[] args) {
        var aa = new ArrayAggregate(new String[]{
            "Objet 1",
            "Objet 2",
            "Objet 3",
            "Objet 4",
            "Objet 5",
            "Objet 6",
            "Objet 7",
        });
        
        System.out.println(" === Itération simple ===");
        //NormalIterator it1 = new NormalIterator(aa);
        NormalIterator it1 = aa.getNormalIterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        
        System.out.println(" === Itération inverse ===");
        //ReverseIterator it2 = new ReverseIterator(aa);
        ReverseIterator it2 = aa.getReverseIterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        
        // 2 itérations simultanées
        System.out.println(" === Itérations simple et inverse ===");
        NormalIterator it3 = aa.getNormalIterator();
        ReverseIterator it4 = aa.getReverseIterator();
        while(it3.hasNext() && it4.hasNext()){
            System.out.println(it3.next() + " -- " + it4.next());
        }
        
    }
}
