
import java.util.Map;
import java.util.HashMap;

public class DataHolder extends Observable{
    
    private Map<String, Double> data = new HashMap<>();
    
    public Map<String, Double> getState(){
        return data;
    }
    
    public void setState(String k, double v){
       data.put(k, v);
       notifyObservers();
    }
    
    
    
}