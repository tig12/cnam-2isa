
public class CountDecorator implements Quackable{
    
    private Quackable quackable;
    
    private static int numberOfQuacks = 0;
    
    public CountDecorator(Quackable quackable){
        this.quackable = quackable;
    }
    
    public void quack(){
        numberOfQuacks++;
        quackable.quack();
//System.out.println("== count " + quackable.getClass().getName());
    }
    
    public static int getNumberOfQuacks(){
        return numberOfQuacks;
    }

	public void registerObserver(Observer observer) {
		quackable.registerObserver(observer);
	}
 
	public void notifyObservers() {
		quackable.notifyObservers();
	}
   
	public String toString() {
		return quackable.toString();
	}

}

