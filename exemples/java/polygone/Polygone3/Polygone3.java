
class Polygone3{
    public static void main(String[] args) {
        Carré c = new Carré();
        PolygoneRégulier pr = c;
        System.out.println("pr.surface() = " + pr.surface());
        System.out.println("c.surface() = " + c.surface());
        //pr.toto();
    }
}

class PolygoneRégulier{
    public String surface(){
        return "surface() dans PolygoneRégulier";
    }
}

class Carré extends PolygoneRégulier{
    public String surface(){
        return "surface() dans Carré";
    }
    
    public void toto(){
        System.out.println("toto dans Carré");
    }
    
}
