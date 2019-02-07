import java.util.List;
import java.util.ArrayList;

/** 
    Exemple illustrant le wildcard permettant d'avoir une hiérarchie d'héritage
**/
public class TestWildcardInheritance{

    public static void main(String[] args){
        List<? extends B> lb = new ArrayList<>();
        List<? extends A>  la = lb;
    }

    class A {}
    class B extends A {}
}