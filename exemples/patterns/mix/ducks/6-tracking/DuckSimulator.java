
public class DuckSimulator {
    
    public void simulate(AbstractQuackableFactory factory){
        
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable rubberDuck = factory.createRubberDuck();
        Quackable goose = factory.createGoose();
        
        Flock f1 = new Flock();
        f1.addChild(mallardDuck);
        f1.addChild(redheadDuck);
        f1.addChild(duckCall);
        f1.addChild(rubberDuck);
        f1.addChild(goose);

        Quackable m1 = factory.createMallardDuck();
        Quackable m2 = factory.createMallardDuck();
        Quackable m3 = factory.createMallardDuck();
        Quackable m4 = factory.createMallardDuck();
        
        Flock f2 = new Flock();
        f2.addChild(m1);
        f2.addChild(m2);
        f2.addChild(m3);
        f2.addChild(m4);
        
        Flock f3 = new Flock();
        f3.addChild(f1);
        f3.addChild(f2);
        
		Quackologist quackologist = new Quackologist();
		f3.registerObserver(quackologist);
		
        // =====
        
        System.out.println("\nDuck Simulator");
        
        simulate(f3);
        
        if(factory instanceof CountingQuackableFactory){
            System.out.println("\nThe ducks quacked : " + CountDecorator.getNumberOfQuacks() + " times");
        }
    }
   
    public void simulate(Quackable duck) {
        duck.quack();
    }
}
