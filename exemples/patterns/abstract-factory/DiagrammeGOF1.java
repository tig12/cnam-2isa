/** 
    Traduction du diagramme original pattern Abstract Factory
    Utilisation d'interfaces pour AbstractFactory et les AbstractProduct
**/

// ====== abstract factory ======
interface AbstractFactory{
    public AbstractProductA createProductA();
    public AbstractProductB createProductB();
}

// ====== concrete factories ======
class ConcreteFactory1 implements AbstractFactory{
    public AbstractProductA createProductA(){ return new ProductA1(); }
    public AbstractProductB createProductB(){ return new ProductB1(); }
}

class ConcreteFactory2 implements AbstractFactory{
    public AbstractProductA createProductA(){ return new ProductA2(); }
    public AbstractProductB createProductB(){ return new ProductB2(); }
}

// ====== abstract products ======
interface AbstractProductA{}
interface AbstractProductB{}

// ====== concrete products ======
class ProductA1 implements AbstractProductA{
    @Override public String toString(){ return this.getClass().getName(); }
}
class ProductB1 implements AbstractProductB{
    @Override public String toString(){ return this.getClass().getName(); }
}

class ProductA2 implements AbstractProductA{
    @Override public String toString(){ return this.getClass().getName(); }
}
class ProductB2 implements AbstractProductB{
    @Override public String toString(){ return this.getClass().getName(); }
}

// ====== client ======
public class DiagrammeGOF1{
    public static void main(String[] args){
        
        AbstractFactory af1 = new ConcreteFactory1();
        AbstractProductA apa = af1.createProductA();
        AbstractProductB apb = af1.createProductB();
        System.out.println("=== AbstractFactory 1 ===");
        System.out.println("    ProductA : " + apa);
        System.out.println("    ProductB : " + apb);
        
        AbstractFactory af2 = new ConcreteFactory2();
        apa = af2.createProductA();
        apb = af2.createProductB();
        System.out.println("=== AbstractFactory 2 ===");
        System.out.println("    ProductA : " + apa);
        System.out.println("    ProductB : " + apb);
    }
}

