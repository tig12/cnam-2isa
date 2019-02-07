
import java.util.Map;
import java.util.HashMap;

public class DataHolder{
    
    private Map<String, Double> data = new HashMap<>();
    
    public Map<String, Double> getState(){
        return data;
    }
    
    public void changeState(String k, double v){
       data.put(k, v);
    }
    
}