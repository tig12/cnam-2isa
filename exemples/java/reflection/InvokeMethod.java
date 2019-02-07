
import java.lang.reflect.*;

public class InvokeMethod {
    
	public static void main(String[] args) {
	    try{
	        //
	        // invoke()
	        //
            Person p = new Person("toto");
            
            Method m;
            
            m = p.getClass().getMethod("getName");
            Object name = m.invoke(p);
            System.out.println(name);
            
            m = p.getClass().getMethod("setName", String.class);
            m.invoke(p, "titi");
            System.out.println(p.getName());
            //
            // newInstance()
            //
            Class<?> c = Person.class;
            Constructor constr = c.getConstructor(String.class);
            Object obj = constr.newInstance("tutu");
            System.out.println(((Person)obj).getName());

	    }
        catch(ReflectiveOperationException e){
            e.printStackTrace();
        }
    }
}

class Person{
    private String name;
    public Person(String name){ this.name = name; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
}

