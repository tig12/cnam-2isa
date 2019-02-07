import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class Filter2{
    public static void main(String[] args) {
        String[] input = {"tiger", "cat", "TIGER", "Tiger", "leopard"};
        List<String> cats = Arrays.asList(input);
        String search = "tiger";
        Predicate<String> p = s -> s.equalsIgnoreCase(search);
        Predicate<String> combined = p.or(s -> s.equals("leopard"));
        String pride = cats.stream()
                           .filter(combined)
                           .collect(Collectors.joining(", "));
        System.out.println(pride);
    }
}