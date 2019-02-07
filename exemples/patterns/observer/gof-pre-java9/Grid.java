import java.util.Observer;
import java.util.Observable;

class Grid implements Observer{
    
    public void update(Observable o, Object arg){
        System.out.print(this.getClass() + ".update(");
        if(arg != null){
            System.out.print(arg);
        }
        System.out.print(")\n");
    }
    
}
