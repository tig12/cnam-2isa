
public class RedheadDuck implements Quackable {
	ObservableHelper observable;

	public RedheadDuck() {
		observable = new ObservableHelper(this);
	}

	public void quack() {
		System.out.println("Redhead Quack");
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

	public String toString() {
		return "Redhead Duck";
	}
}
