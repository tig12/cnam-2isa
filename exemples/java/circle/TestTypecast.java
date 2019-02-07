
public class TestTypecast{

    public static void main(String[] args){
        PlaneCircle pc1 = new PlaneCircle(1.0, 0.0, 0.0);
        Circle c1 = pc1; // widening conversion
        PlaneCircle pc1bis = (PlaneCircle) c1; // narrowing conversion OK
        System.out.println("pc1bis : " + pc1bis);
        
        Circle c2 = new Circle();
        PlaneCircle pc2 = (PlaneCircle) c2; // narrowing conversion erreur exécution
        System.out.println("pc2 : " + pc2);
    }
    
}
