
import java.util.Map;

public class Bar{

    private DataHolder data;
    
    public Bar(DataHolder data){
        this.data = data;
    }
    
    public void print(){
        System.out.println(this.getClass());
        Map<String, Double> tmp = data.getState();
        tmp.forEach( (k,v) -> System.out.println(k + " : " + v) );
        System.out.println();
    }
}
