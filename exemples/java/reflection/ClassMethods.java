
import java.lang.reflect.*;
import java.util.List;
import java.util.ArrayList;

public class ClassMethods {
    
	public static void main(String[] args) {
	    try{
            // classMethods(Class.forName("java.lang.Class"));
            //classMethods(Class.forName("java.util.stream.Stream"));
            classMethods(Class.forName("java.lang.reflect.Method"));
	    }
        catch(ReflectiveOperationException e){
            e.printStackTrace();
        }
    }
    
	public static void classMethods(Class<?> c) {
        System.out.println("===== Methods of : " + c.getCanonicalName() + " =====");
        for(Method m : c.getDeclaredMethods()){
            //System.out.println(m.toGenericString());
            System.out.println();
            String modifiers = Modifier.toString(m.getModifiers());
            System.out.print(modifiers == "" ? "void" : modifiers);
            System.out.print(" " + m.getReturnType().getSimpleName());
            System.out.print(" " + m.getName());
            // params
            System.out.print("(");
            List<String> params = new ArrayList<>();
            for(Parameter param : m.getParameters()){
                params.add(param.getType().getSimpleName());
            }
            System.out.print(String.join(", ", params));
            System.out.print(")");
        }
        System.out.println();
    }
    
}

