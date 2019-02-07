
/** 
    Montre un exemple d'utilisation de bounded type dans une méthode générique.
    Le type U peut être différent du type T
**/

public class BoundedTypeInGenericMethod{
    public static void main(String[] args) {
        Box<Integer> ib = new Box<Integer>();
        ib.set(Integer.valueOf(10));
        // ib.inspect("some text"); // erreur de compilation
        ib.inspect(3.2);
    }
}

class Box<T> {
    private T t;          

    public void set(T t) { this.t = t; }

    public T get() { return t; }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
}

