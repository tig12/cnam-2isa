/** 
    Adaptation de https://sourcemaking.com/design_patterns/iterator
**/
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class IntegerBox {
    private List<Integer> list = new ArrayList<>();

    public class Iterator {
        private IntegerBox box;
        private java.util.Iterator iterator;
        private int value;

        public Iterator(IntegerBox integerBox) {
            box = integerBox;
        }

        public void first() {
            iterator = box.list.iterator();
            next();
        }

        public void next() {
            try {
                value = (Integer)iterator.next();
            } catch (NoSuchElementException ex) {
                value =  -1;
            }
        }

        public boolean isDone() {
            return value == -1;
        }

        public int currentValue() {
            return value;
        }
    }

    public void add(int in) {
        list.add(in);
    }

    public Iterator getIterator() {
        return new Iterator(this);
    }
}

public class BoxDemo{
    
    public static void main(String[] args) {
        // fill the box
        IntegerBox integerBox = new IntegerBox();
        for (int i = 9; i > 0; --i) {
            integerBox.add(i);
        }
        
        IntegerBox.Iterator itr1 = integerBox.getIterator();
        IntegerBox.Iterator itr2 = integerBox.getIterator();
        
        // One ineration
        for (itr1.first(); !itr1.isDone(); itr1.next()) {
            System.out.print(itr1.currentValue() + "  ");
        }
        System.out.println();
        
        // Two simultaneous iterations
        for (itr1.first(), itr2.first(); !itr1.isDone(); itr1.next(), itr2.next()) {
            System.out.print(itr1.currentValue() + " " + itr2.currentValue() + "  ");
        }
        System.out.println();
    }
}