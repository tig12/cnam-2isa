
import java.util.Iterator;
import java.util.ArrayList;

public class ObservableHelper implements Quackable {
	ArrayList<Observer> observers = new ArrayList<Observer>();
	Quackable duck;
 
	public ObservableHelper(Quackable duck) {
		this.duck = duck;
	}
  
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
  
	public void notifyObservers() {
		Iterator<Observer> iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = iterator.next();
			observer.update(duck);
		}
	}
 
	public Iterator<Observer> getObservers() {
		return observers.iterator();
	}
}

