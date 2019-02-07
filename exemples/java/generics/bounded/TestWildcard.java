import java.util.List;
import java.util.Arrays;


/** 
    Teste un usage où le wildcard peut être évité.
**/
public class TestWildcard{

    public static void main(String[] args){
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sumOfList1 = " + sumOfList1(li));
        System.out.println("sumOfList2 = " + sumOfList2(li));
    }

    public static double sumOfList1(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
    
    public static <T extends Number> double sumOfList2(List<T> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;                                                                                                         
    }
    
}