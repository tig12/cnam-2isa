

public class Main{
    
    public static void main(String[] args){
        
        Camera cameraPortail = new Camera("Camera portail");
        Camera cameraBergerie = new Camera("Camera bergerie");
        
        Paysan paysan1 = new Paysan("Paysan 1");
        Paysan paysan2 = new Paysan("Paysan 2");
        Gendarme gendarme1 = new Gendarme("Gendarme 1");
        
        // ici, n'oubliez pas d'associer les observateurs aux observables
        
        cameraPortail.detecte("Un loup a franchi le portail");
        cameraBergerie.detecte("Un loup est entré dans la bergerie");
    }
}
