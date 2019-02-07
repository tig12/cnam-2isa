/** 
    Traduction du diagramme original
**/

/** Interface implémentée par le composant décoré et les décorateurs **/
interface Component{
    public void operation();
}

/** Le composant décoré **/
class ConcreteComponent implements Component{
    public void operation(){
        System.out.println("  ConcreteComponent.operation()");
    }
}

/** Le décorateur abstrait **/
abstract class Decorator implements Component{
    private Component component;
    public Decorator(Component component){
        this.component = component;
    }
    public void operation(){
        component.operation();
    }
}

// Les décorateurs concrets

class ConcreteDecoratorA extends Decorator{
    public ConcreteDecoratorA(Component component){
        super(component);
    }

    public void operation(){
        addedBehaviour();
        super.operation();
    }
    
    private void addedBehaviour(){
        System.out.println("  ConcreteDecoratorA.addedBehaviour()");
    }
}


/** Code client **/
public class DiagrammeGOF{
    public static void main(String[] args){
        System.out.println("=== c1 (pas de décoration) ===");
        Component c1 = new ConcreteComponent();
        c1.operation();
        
        System.out.println("\n=== c2 (décoration par ConcreteDecoratorA) ===");
        Component c2 = new ConcreteDecoratorA(new ConcreteComponent());
        c2.operation();
    }
}

