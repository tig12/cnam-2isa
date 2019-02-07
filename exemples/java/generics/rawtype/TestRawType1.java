import java.util.List;
import java.util.ArrayList;

public class TestRawType1{
    public static void main(String[] args){
        List l = new ArrayList();
        l.add("hello");
        l.add(Integer.valueOf(3));
        String s1 = (String) l.get(0);
        String s2 = (String) l.get(1);
    }
}
