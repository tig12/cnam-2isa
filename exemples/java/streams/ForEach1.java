import java.util.*;
import java.util.stream.Collectors;

public class ForEach1{
    public static void main(String[] args) {
        String[] input = {"tiger", "cat", "TIGER", "Tiger", "leopard"};
        List<String> cats = Arrays.asList(input);        
        cats.forEach(System.out::println);
    }
}