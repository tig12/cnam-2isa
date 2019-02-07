
public class RubberDuck implements Quackable {
	ObservableHelper observable;

	public RubberDuck() {
		observable = new ObservableHelper(this);
	}
 
	public void quack() {
		System.out.println("RubberDuck quack");
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
  
	public String toString() {
		return "Rubber Duck";
	}
}

