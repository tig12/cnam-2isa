
public class DuckCall implements Quackable {
	ObservableHelper observable;

	public DuckCall() {
		observable = new ObservableHelper(this);
	}
 
	public void quack() {
		System.out.println("DuckCall quack");
		notifyObservers();
	}
 
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
 
	public String toString() {
		return "Duck Call";
	}
}
