import java.util.stream.Stream;

public class Reduce1{
    public static void main(String[] args) {
        //int sommePremiers = Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23)
        int sommePremiers = Stream.of(2, 3, 4)
            .reduce(0, (x, y) -> {System.out.println("x = : " + x);System.out.println("y = : " + y);return x + 2*y;});
        System.out.println("Somme : " + sommePremiers);
    }
}
