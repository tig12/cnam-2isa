
import java.util.List;
import java.util.ArrayList;

/* 
    Erreur à la compilation
*/
public class TestGenerics2{

    public static void main(String[] args){
        List<String> l = new ArrayList<String>();
        l.add("hello");
        l.add(Integer.valueOf(3));          // erreur de compilation
        String s1 = (String) l.get(0);
        String s2 = (String) l.get(1);
    }

}
