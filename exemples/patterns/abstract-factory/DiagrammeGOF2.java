/** 
    Traduction du diagramme original pattern Abstract Factory
    Utilisation de classes pour AbstractFactory et les AbstractProduct
    ( permet de factoriser l'implémentation de toString() )
**/

// ====== abstract factory ======
class AbstractFactory{
    public AbstractProductA createProductA(){ return new AbstractProductA(); }
    public AbstractProductB createProductB(){ return new AbstractProductB(); }
}

// ====== concrete factories ======
class ConcreteFactory1 extends AbstractFactory{
    public AbstractProductA createProductA(){ return new ProductA1(); }
    public AbstractProductB createProductB(){ return new ProductB1(); }
}

class ConcreteFactory2 extends AbstractFactory{
    public AbstractProductA createProductA(){ return new ProductA2(); }
    public AbstractProductB createProductB(){ return new ProductB2(); }
}

// ====== abstract products ======
class AbstractProductA{
    @Override public String toString(){ return this.getClass().getName(); }
}
class AbstractProductB{
    @Override public String toString(){ return this.getClass().getName(); }
}

// ====== concrete products ======
class ProductA1 extends AbstractProductA{}
class ProductB1 extends AbstractProductB{}
class ProductA2 extends AbstractProductA{}
class ProductB2 extends AbstractProductB{}

// ====== client ======
public class DiagrammeGOF2{
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

