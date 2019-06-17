
/** 
    Implémentation d'un itérateur simple.
    Répond à la demande de pouvoir itérer avec un objet distinct de l'aggrégat,
    mais ne correspond pas au pattern Iterator car n'implémente pas les notions
    d'itérateur abstrait et d'aggrégat abstrait.
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
    
    /** 
        Itérateur pour parcourir un ArrayAggregate
    **/
    public class NormalIterator {
        
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
            return aa.data[index];
        }
        
        /** 
            Indique s'il reste des éléments à parcourir
        **/
        public boolean hasNext() {
            return index < aa.data.length - 1;
        }
    }
    
    /** 
        Itérateur pour parcourir un ArrayAggregate en sens inverse
    **/
    public class ReverseIterator {
        
        /** L'aggrégat parcouru par cet itérateur **/
        private ArrayAggregate aa;
        
        /** Index courant de l'itération **/
        private int index;
        
        public ReverseIterator(ArrayAggregate aa){
            this.aa = aa;
            this.index = aa.data.length;
        }
        
        /** 
            Renvoie l'élément courant et avance la position de l'itération
        **/
        public Object next() {
            index--;
            return aa.data[index];
        }
        
        /** 
            Indique s'il reste des éléments à parcourir
        **/
        public boolean hasNext() {
            return index > 0;
        }
    }
    
}

public class DemoSimple{
    
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
        //ArrayAggregate.NormalIterator it1 = aa.new NormalIterator(aa);
        ArrayAggregate.NormalIterator it1 = aa.getNormalIterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        
        System.out.println(" === Itération inverse ===");
        //ArrayAggregate.ReverseIterator it2 = aa.new ReverseIterator(aa);
        ArrayAggregate.ReverseIterator it2 = aa.getReverseIterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        
        // 2 itérations simultanées
        System.out.println(" === Itérations simple et inverse ===");
        ArrayAggregate.NormalIterator it3 = aa.getNormalIterator();
        ArrayAggregate.ReverseIterator it4 = aa.getReverseIterator();
        while(it3.hasNext() && it4.hasNext()){
            System.out.println(it3.next() + " -- " + it4.next());
        }
        
    }
}
