

public class NormalQuackableFactory implements AbstractQuackableFactory{
    public Quackable createDuckCall()   { return new DuckCall(); }
    public Quackable createGoose()      { return new GooseAdapter(new Goose()); }
    public Quackable createMallardDuck(){ return new MallardDuck(); }
    public Quackable createRedheadDuck(){ return new RedheadDuck(); }
    public Quackable createRubberDuck() { return new RubberDuck(); }
}
