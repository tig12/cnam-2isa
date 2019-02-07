
public class DuckSimulator {
    
    public void simulate(AbstractQuackableFactory factory){
	    
		Quackable mallardDuck = factory.createMallardDuck();
		Quackable redheadDuck = factory.createRedheadDuck();
		Quackable duckCall = factory.createDuckCall();
		Quackable rubberDuck = factory.createRubberDuck();
		Quackable goose = factory.createGoose();
        
		System.out.println("\nDuck Simulator");
 
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(goose);
		
		if(factory instanceof CountingQuackableFactory){
		    System.out.println("\nNumber of quacks : " + CountDecorator.getNumberOfQuacks());
		}
	}
   
	public void simulate(Quackable duck) {
		duck.quack();
	}
}
