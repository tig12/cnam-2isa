/**
    Exemple avec flyweight, cf Gazillion1 pour exemple sans flyweight.
    source : https://sourcemaking.com/design_patterns/flyweight/java/1
    
    In this refactoring, the "row" state is considered shareable (within each row anyways),
    and the "col" state has been externalized (it is supplied by the client when report() is called). 
**/

class Gazillion2 {
    private int row;

    public Gazillion2(int row) {
        this.row = row;
        //System.out.println("ctor: " + this.row);
    }

    void report(int col) {
        System.out.print(" " + row + col);
    }
}

class Factory {
    private Gazillion2[] pool;

    public Factory(int maxRows) {
        pool = new Gazillion2[maxRows];
    }

    public Gazillion2 getFlyweight(int row) {
        if (pool[row] == null) {
            pool[row] = new Gazillion2(row);
        }
        return pool[row];
    }
}

public class Gazillion2Demo {
    public static final int ROWS = 6, COLS = 10;

    public static void main(String[] args) {
        Factory theFactory = new Factory(ROWS);
        for (int i=0; i < ROWS; i++) {
            for (int j=0; j < COLS; j++)
                theFactory.getFlyweight(i).report(j);
            System.out.println();
        }
    }
}
