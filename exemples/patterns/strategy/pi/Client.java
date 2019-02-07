
public class Client{
    
    private PiInterface piStrategy;
    
    private PiContext piContext;
    
    public void setStrategy(PiInterface piStrategy){
        this.piStrategy = piStrategy;
    }
    
    public void setContext(PiContext piContext){
        this.piContext = piContext;
    }
    
    public double calculePi(){
        return piStrategy.calculePi(piContext);
    }
    
}