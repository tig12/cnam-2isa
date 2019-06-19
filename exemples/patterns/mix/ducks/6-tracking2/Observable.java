import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public abstract class Observable implements Quackable{
    
	ArrayList<Observer> observers = new ArrayList<Observer>();

    public void quack(){
        notifyObservers();
    }
    
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
  
	public void notifyObservers() {
//System.out.println("notifyObservers " + this);
		Iterator<Observer> iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = iterator.next();
			observer.update(this);
		}
	}
 
	public Iterator<Observer> getObservers() {
		return observers.iterator();
	}
	
}