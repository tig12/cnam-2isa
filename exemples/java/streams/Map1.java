import java.util.*;
import java.util.stream.Collectors;

public class Map1{
    public static void main(String[] args) {
        String[] input = {"tiger", "cat", "TIGER", "Tiger", "leopard"};
        List<String> cats = Arrays.asList(input);        
        List<Integer> namesLength = cats
            .stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println(namesLength);        
    }
}