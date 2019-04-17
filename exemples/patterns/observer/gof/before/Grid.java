
import java.util.Map;

public class Grid{

    private DataHolder data;
    
    public Grid(DataHolder data){
        this.data = data;
    }
    
    public void print(){
        System.out.println(this.getClass());
        Map<String, Double> tmp = data.getState();
        tmp.forEach( (k,v) -> System.out.println(k + " : " + v) );
        System.out.println();
    }
}
