
import java.util.Map;

public class Pie{

    private DataHolder data;
    
    public Pie(DataHolder data){
        this.data = data;
    }
    
    public void print(){
        System.out.println(this.getClass());
        Map<String, Double> tmp = data.getState();
        tmp.forEach( (k,v) -> System.out.println(k + " : " + v) );
        System.out.println();
    }
}
