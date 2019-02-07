

public class Camera{
    private String name;
    
    private String message;
    
    public Camera(String name){
        this.name = name;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void detecte(String message){
        this.message = message;
    }
    
    public String toString(){ return name; }
}

