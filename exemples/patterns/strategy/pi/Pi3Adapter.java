

public class Pi3Adapter implements PiInterface{

    public double calculePi(PiContext c){
        return Pi3.calculePi(c.getN());
    }
    
}