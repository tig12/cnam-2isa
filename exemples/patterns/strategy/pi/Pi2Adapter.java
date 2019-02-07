

public class Pi2Adapter implements PiInterface{

    public double calculePi(PiContext c){
        return Pi2.calculePi(c.getN());
    }
    
}