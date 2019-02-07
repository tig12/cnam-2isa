
public interface Quackable {
    
	default public void quack(){}

	default public void registerObserver(Observer observer){}
	default public void notifyObservers(){}
	
}
