
import java.util.List;
import java.util.ArrayList;

public class Flock implements Quackable{
    
    private List<Quackable> children = new ArrayList<Quackable>();
    
	public void quack(){
	    for(Quackable q : children){
	        q.quack();
	    }
	}
	
	// ==== child operations ====
	
	public Quackable getChild(int index){
	    return children.get(index);
	}
	
	public void addChild(Quackable q){
	    children.add(q);
	}
	
}                                                                                                                                                                  
