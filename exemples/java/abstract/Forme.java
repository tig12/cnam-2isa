abstract class Forme{
    public abstract double aire();
    public abstract double circonference();
}

class Carre extends Forme{
    public double aire(){ return 1.0; }
    public double circonference(){ return 1.0; }
}

class Triangle extends Forme{
    public double aire(){ return 1.0; }
    public double circonference(){ return 1.0; }
}