

public class CountingQuackableFactory implements AbstractQuackableFactory{
    public Quackable createDuckCall()   { return new CountDecorator(new DuckCall()); }
    public Quackable createGoose()      { return new GooseAdapter(new Goose()); }
    public Quackable createMallardDuck(){ return new CountDecorator(new MallardDuck()); }
    public Quackable createRedheadDuck(){ return new CountDecorator(new RedheadDuck()); }
    public Quackable createRubberDuck() { return new CountDecorator(new RubberDuck()); }
}