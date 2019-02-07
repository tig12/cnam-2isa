import java.util.Observable;

class Data extends Observable{
    
    public void changeState(){
        this.setChanged();
    }
    
}