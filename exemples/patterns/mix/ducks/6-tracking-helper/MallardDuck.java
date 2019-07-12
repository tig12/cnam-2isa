
public class MallardDuck implements Quackable {
	ObservableHelper observable;
 
	public MallardDuck() {
		observable = new ObservableHelper(this);
	}
 
	public void quack() {
		System.out.println("Mallard Quack");
		notifyObservers();
	}
 
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}
 
	public void notifyObservers() {
		observable.notifyObservers();
	}
 
	public String toString() {
		return "Mallard Duck";
	}
}
