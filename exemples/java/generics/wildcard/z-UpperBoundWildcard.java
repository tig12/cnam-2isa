import java.util.List;
import java.util.ArrayList;

public class UpperBoundWildcard{
    public static void main(String[] args){
        //test1(new Number(4));
        
    }
    
    public static void test1(List<Number> l){}
//    public static void test2(List<T extends Number> l){}
    public static <T extends Number> void test2(T t){}

    public static void test3(List<? extends Number> l){}
}
