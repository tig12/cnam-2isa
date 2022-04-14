import java.util.function.Function;

/** Exemple en utilisant java.util.function.Function **/
class FunctionDemo1 {
    public static void main(String args[]) {
        Function<Integer, Integer> f = x -> x + 2;
        System.out.println(f.apply(6));
    }
}

/** Même chose que FunctionDemo1, en définissant la functional interface de manière classique **/
class FunctionDemo2 {
    public static void main(String args[]) {
        Ajouter f = (x) -> x + 2;
        System.out.println(f.apply(6));
    }
    private interface Ajouter {
        int apply(int x);
        // En utilisant l'autoboxing, on aurait aussi pu écrire :
        // Integer apply(Integer x);
    }
}
