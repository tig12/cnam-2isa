
public class CountDecorator implements Quackable{
    private Quackable quackable;
    
    private static int numberOfQuacks = 0;
    
    public CountDecorator(Quackable quackable){
        this.quackable = quackable;
    }
    public void quack(){
        numberOfQuacks++;
        quackable.quack();
    }
    public static int getNumberOfQuacks(){
        return numberOfQuacks;
    }
}
