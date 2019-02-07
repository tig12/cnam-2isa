
public class DuckSimulator {
    public void simulate(){
		Quackable mallardDuck = new MallardDuck();
		Quackable redheadDuck = new RedheadDuck();
		Quackable duckCall = new DuckCall();
		Quackable rubberDuck = new RubberDuck();
		Quackable goose = new GooseAdapter(new Goose());
 
		System.out.println("\nDuck Simulator");
 
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(goose);
	}
   
	public void simulate(Quackable duck) {
		duck.quack();
	}
}
