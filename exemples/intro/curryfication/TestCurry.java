
import java.util.function.Function;
import java.util.function.BiFunction;

public class TestCurry{

    public static void main(String[] args){
        BiFunction<Integer, Integer, Integer> uncurriedSum = (x1, x2) -> x1 + x2;
        Function2<Integer, Integer, Integer> curriedSum = Function2.curried(uncurriedSum);
        Function<Integer, Integer> add2 = curriedSum.apply(2);
        System.out.println("add2.apply(2) = " + add2.apply(2)); // 4 = uncurriedSum(2,2)
        System.out.println("add2.apply(4) = " + add2.apply(4)); // 6 = uncurriedSum(2,4)
    }
}

@FunctionalInterface
interface Function2<T, U, R> extends Function<T, Function<U, R>> {

   static <T, U, R> Function2<T, U, R> curried(BiFunction<T, U, R> f) {
        return t -> u -> f.apply(t, u);
    }
}
