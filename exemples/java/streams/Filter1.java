import java.util.*;
import java.util.stream.Collectors;

public class Filter1{
    public static void main(String[] args) {
        String[] input = {"tiger", "cat", "TIGER", "Tiger", "leopard"};
        String search = "tiger";
        String tigers = Arrays.stream(input)
            .filter(s -> s.equalsIgnoreCase(search))
            .collect(Collectors.joining(", "));
        System.out.println(tigers);
    }
}