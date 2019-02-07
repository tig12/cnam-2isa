import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

class CreatePathExamples{
    
    public static void main(String[] args){
        Path p1 = Paths.get("/tmp/foo");
        Path p2 = Paths.get("tmp", "foo");
        Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
    }
}