
class Polygone1{
    public static void main(String[] args) {
        PolygoneRégulier pr = new PolygoneRégulier();
        Carré c = new Carré();
        System.out.println("pr.surface() = " + pr.surface());
        System.out.println("c.surface() = " + c.surface());

    }
}

class PolygoneRégulier{
    public String surface(){
        return "surface() dans PolygoneRégulier";
    }
}

class Carré extends PolygoneRégulier{
    // vide
}
