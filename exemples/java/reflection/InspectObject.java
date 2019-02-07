
import java.lang.reflect.*;

public class InspectObject {
    
	public static void main(String[] args) {
        inspect(new String("toto"));
    }
    
	public static void inspect(Object obj) {
	    try{
            for (Field f : obj.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                Object value = f.get(obj);
                System.out.println(f.getName() + ":" + value);
            }
	    }
        catch(ReflectiveOperationException e){
            e.printStackTrace();
        }
    }
}

