
public class DuckSimulator {
    
    public void simulate(){
		Quackable mallardDuck = new CountDecorator(new MallardDuck());
		Quackable redheadDuck = new CountDecorator(new RedheadDuck());
		Quackable duckCall = new CountDecorator(new DuckCall());
		Quackable rubberDuck = new CountDecorator(new RubberDuck());
		Quackable goose = new GooseAdapter(new Goose());
        
		System.out.println("\n=== Duck Simulator ===");
        
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(goose);
		
		System.out.println("\nNumber of quacks : " + CountDecorator.getNumberOfQuacks());
	}
   
	static void simulate(Quackable duck) {
		duck.quack();
	}
}
