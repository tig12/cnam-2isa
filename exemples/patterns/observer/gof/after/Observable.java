import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public abstract class Observable{

    protected List<Observer> observers = new ArrayList<>();
    
    public void attach(Observer o){
        observers.add(o);
    }
    
    public void detach(Observer o){
        observers.remove(o);
    }
    
    public void notifyObservers(){
        for(Observer o: observers){
            o.update(this);
        }
    }
    
    public abstract void setState(String k, double v);
    
    public abstract Map<String, Double> getState();
}
