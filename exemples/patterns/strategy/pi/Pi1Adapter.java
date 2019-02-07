

public class Pi1Adapter implements PiInterface{

    public double calculePi(PiContext c){
        return Pi1.calculePi(c.getN());
    }
    
}