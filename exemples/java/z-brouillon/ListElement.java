
import java.util.List;
import java.util.ArrayList;

class ListElement{

	public static void main(String[] args){
	    //test1();
	    test2();
	}
	
    /* 
        code de Sergei non modifié
        erreur compilation :
        error: bad operand types for binary operator '+'
        System.out.println("class: " + (5 + s)); // erreur
    */
    /* 
    public static void test1(){
        List l = new ArrayList();
        l.add("hello");
        l.add(new Integer(3));
        
        Object s = l.get(1);
        System.out.println("class: " + (5 + s)); // erreur
    }
    */
    
    /* 
        code de Thierry
        Object.getClass()
        Returns : The Class object that represents the runtime class of this object.
    */
    public static void test2(){
        List l = new ArrayList();
        l.add("hello");
        l.add(new Integer(3));
        
        Object s = l.get(1);
        System.out.println("s = " + s); // s = 3
        System.out.println("s.getClass() = " + s.getClass()); // s.getClass() = class java.lang.Integer
        // int t = 5 + s; // erreur compil
            // error: bad operand types for binary operator '+'
            // first type:  int
            // second type: Object

        int t = 5 + ((Integer)s).intValue();
        System.out.println("t = " + t); // t = 8
        
        Integer u = (Integer)l.get(1);
        System.out.println("u = " + u); // u = 3
        System.out.println("u.getClass() = " + u.getClass()); // u.getClass() = class java.lang.Integer
        int v = 5 + u;
        
        System.out.println((5 + u)); // 8
    }
}