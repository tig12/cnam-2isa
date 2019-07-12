

public class DuckSimulator {
    
    public void simulate(AbstractQuackableFactory factory){
        
        Quackologist quackologist = new Quackologist();
        
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable rubberDuck = factory.createRubberDuck();
        Quackable goose = factory.createGoose();
        
        mallardDuck.registerObserver(quackologist);
        redheadDuck.registerObserver(quackologist);
        duckCall.registerObserver(quackologist);
        rubberDuck.registerObserver(quackologist);
        goose.registerObserver(quackologist);
        
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
        m1.registerObserver(quackologist);
        m2.registerObserver(quackologist);
        m3.registerObserver(quackologist);
        m4.registerObserver(quackologist);
        
        Flock f2 = new Flock();
        f2.addChild(m1);
        f2.addChild(m2);
        f2.addChild(m3);
        f2.addChild(m4);
        
        Flock f3 = new Flock();
        f3.addChild(f1);
        f3.addChild(f2);
        
        // =====
        
        
		System.out.println("\n=== Duck Simulator ===");
        
        System.out.println("\nDuck Simulator: Whole flock simulation");
        simulate(f3);
        
        System.out.println("\nDuck Simulator: Mallard flock simulation");
        simulate(f2);
        
        if(factory instanceof CountingQuackableFactory){
            System.out.println("\nThe ducks quacked : " + CountDecorator.getNumberOfQuacks() + " times");
        }
    }
   
    public void simulate(Quackable duck) {
        duck.quack();
    }
}
