
class Polygone4{
    public static void main(String[] args) {
        Carré c = new Carré();
        Hexagone h = new Hexagone();
        PolygoneRégulier p1 = c;
        PolygoneRégulier p2 = h;
        System.out.println("AVANT, p1.surface() = " + p1.surface());
        p1 = p2;
        System.out.println("APRES, p1.surface() = " + p1.surface());

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
}

class Hexagone extends PolygoneRégulier{
    public String surface(){
        return "surface() dans Hexagone";
    }
}
