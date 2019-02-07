import java.nio.file.Path;
import java.nio.file.Paths;

class PathExamples{
    
    public static void main(String[] args){
        
        // sous Windows : Path home = Paths.get("c:\\Users\\Moi");
        Path home = Paths.get("/home/moi");
        System.out.println(home);    // /home/moi
        
        Path p1 = home.resolve("dev/myapp/src");
        // Equivalent à : Path p1 = home.resolve(Paths.get("dev/myapp/src"));
        System.out.println(p1);    // /home/moi/dev/myapp/src
        
        Path p2 = p1.resolveSibling("tmp.txt");
        System.out.println(p2);    // /home/moi/dev/myapp/tmp.txt
        
        Path p3 = p1.relativize(Paths.get("/home/moi/dev/myapp2/src"));
        System.out.println(p3);    // ../../myapp2/src
        
        // part de l'endroit où a été démarrée la JVM
        Path p4 = Paths.get("config").toAbsolutePath();
        System.out.println(p4);    // /home/thierry/dev/jobs/cnam/git-repos/public/exemples/java/nio/config
        
        Path test;
        test = p2.getParent();
        System.out.println(test);       // /home/moi/dev/myapp
        test = p2.getFileName(); // le dernier élément
        System.out.println(test);       // tmp.txt
        test = p2.getRoot(); // "/" ou "C:\" ou null pour un chemin relatif
        System.out.println(test);       // /
        test = p2.getName(0); // le premier element
        System.out.println(test);       // home
        test = p2.subpath(1, p2.getNameCount()); // tout sauf le premier élément
        System.out.println(test);       // moi/dev/myapp/tmp.txt
        
        // Utilise le fait que Path extends Iterable<Path>
        for (Path component : p4) {
            System.out.print(component + " - ");
        }
        System.out.println();
        // home - thierry - dev - jobs - cnam - git-repos - public - exemples - java - nio - config -
    }
}