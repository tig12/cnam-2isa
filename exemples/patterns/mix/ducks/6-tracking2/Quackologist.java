
public class Quackologist implements Observer{

    public void update(Observable o){
        System.out.println(" " + o + " a fait un quack");
    }
    

}