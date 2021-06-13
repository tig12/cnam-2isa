
/** 
    Implémentation du pattern Iterator
    Complète l'exemple DemoSimple en introduisant les notions
    d'itérateur abstrait et d'aggrégat abstrait.
**/


// ========= 1 - Aggrégat abstrait =========
interface Aggregate{
    public NormalIterator getNormalIterator();
    public ReverseIterator getReverseIterator();
}

// ========= 2 - Itérateurs abstraits =========
interface Iterator{
    public Object next();
    public boolean hasNext();
}
interface NormalIterator extends Iterator{}
interface ReverseIterator extends Iterator{}


// ========= 3 - Aggrégats concrets et leurs itérateurs =========

class ArrayAggregate implements Aggregate{
    
    private Object[] data;
    
    public ArrayAggregate(Object[] data){
        this.data = data;
    }
    
    public NormalIterator getNormalIterator() {
        return new ArrayAggregateNormalIterator(this);
    }
    
    public ReverseIterator getReverseIterator() {
        return new ArrayAggregateReverseIterator(this);
    }
    
    /** 
        Itérateur pour parcourir un ArrayAggregate
    **/
    public class ArrayAggregateNormalIterator implements NormalIterator{
        
        /** L'aggrégat parcouru par cet itérateur **/
        private ArrayAggregate aa;
        
        /** Index courant de l'itération **/
        private int index;
        
        public ArrayAggregateNormalIterator(ArrayAggregate aa){
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
    public class ArrayAggregateReverseIterator implements ReverseIterator{
        
        /** L'aggrégat parcouru par cet itérateur **/
        private ArrayAggregate aa;
        
        /** Index courant de l'itération **/
        private int index;
        
        public ArrayAggregateReverseIterator(ArrayAggregate aa){
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

// ========= 4 - Code client =========
public class DemoIteratorComplet{
    
    public static void main(String[] args) {
        Aggregate aa = new ArrayAggregate(new String[]{
            "Objet 1",
            "Objet 2",
            "Objet 3",
            "Objet 4",
            "Objet 5",
            "Objet 6",
            "Objet 7",
        });
        
        System.out.println(" === Itération simple ===");
        NormalIterator it1 = aa.getNormalIterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        
        System.out.println(" === Itération inverse ===");
        ReverseIterator it2 = aa.getReverseIterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        
        System.out.println(" === Itérations simple et inverse ===");
        NormalIterator it3 = aa.getNormalIterator();
        ReverseIterator it4 = aa.getReverseIterator();
        while(it3.hasNext() && it4.hasNext()){
            System.out.println(it3.next() + " -- " + it4.next());
        }
        
    }
}
