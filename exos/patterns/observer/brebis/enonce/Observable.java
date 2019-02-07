

import java.util.List;
import java.util.ArrayList;

public abstract class Observable{
    
    protected List<Observer> observers = new ArrayList<Observer>();
    
    public void addObserver(Observer o){
        observers.add(o);
    }
    
    public void notifyObservers(){
        for(Observer o : observers){
            o.update(this, getArguments());
        }
    }
    
    public abstract Object getArguments();
    
}