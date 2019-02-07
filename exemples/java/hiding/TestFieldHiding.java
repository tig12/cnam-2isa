
public class TestFieldHiding{
    public static void main(String[] args){
        C c = new C();
        c.print();
    }
}

class A{
    public String x = "A";
}
class B extends A{
    public String x = "B";
}
class C extends B{
    public String x = "C";
    
    public void print(){
        System.out.println("x = \t\t" + x);
        System.out.println("this.x = \t" + this.x);
        System.out.println("super.x = \t" + super.x);
        System.out.println("((B)this).x = \t" + ((B)this).x);
        System.out.println("((A)this).x = \t" + ((A)this).x);
    }
}
