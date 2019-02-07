
import java.util.Map;
import java.util.HashMap;

public class Pie implements Observer{

    private Map<String, Double> state = new HashMap<>();
    
    public void update(Observable o){
        state = o.getState();
    }
    
    public void print(){
        System.out.println(this.getClass());
        state.forEach( (k,v) -> System.out.println(k + " : " + v) );
        System.out.println();
    }
}
                                                                                                                                           