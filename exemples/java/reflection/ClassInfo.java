
import java.lang.reflect.*;

public class ClassInfo {
    
	public static void main(String[] args) {
	    try{
            classInfo(Class.forName("ClassInfo"), true);
            classInfo(Class.forName("java.util.Scanner"), false);
            classInfo(String[].class, true);
            classInfo(int.class, true);
            classInfo(void.class, true);
            
            
	    }
        catch(ReflectiveOperationException e){
            e.printStackTrace();
        }
	}
	                                                        
	public static void classInfo(Class<?> c, boolean displayMethods) {
            
            System.out.println("\n===== c = " + c + " =====");
            System.out.println("c.getName() = " + c.getName());
            System.out.println("c.getCanonicalName() = " + c.getCanonicalName());
            System.out.println("c.getSimpleName() = " + c.getSimpleName());
            System.out.println("c.getTypeName() = " + c.getTypeName());
            System.out.println("c.toString() = " + c.toString());
            System.out.println("c.toGenericString() = " + c.toGenericString());
            //
            
            System.out.println("c.getSuperclass() =  " + c.getSuperclass());
            try{
                System.out.println("__DIR__ =  " + c.getProtectionDomain().getCodeSource().getLocation().toExternalForm());
            } 
            catch(NullPointerException e){}
            
            Class<?>[] interfaces = c.getInterfaces();
            if(interfaces.length != 0){
                System.out.println("Interfaces : ");
                for(Class i : interfaces){
                    System.out.println("  " + i);
                }
            }
            
            
            if(displayMethods){
                Method[] methods = c.getDeclaredMethods();            
                //Method[] methods = c.getMethods();            
                if(methods.length != 0){
                    System.out.println("Methods : ");
                    for(Method m : methods){
                        System.out.println("  " + m);
                    }
                }
            }
            
	}
	
}
