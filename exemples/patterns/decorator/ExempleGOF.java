/**
    Traduction de l'exemple GOF
**/

// Interface implémentée par le composant décoré et les décorateurs
interface VisualComponent{
    public void draw();
}

// Le composant décoré
class TextView implements VisualComponent{
    public void draw(){
        System.out.println("  TextView.draw()");
    }
}

// Le décorateur abstrait
abstract class Decorator implements VisualComponent{
    private VisualComponent component;
    public Decorator(VisualComponent component){
        this.component = component;
    }
    public void draw(){
        component.draw();
    }
}

// Les décorateurs concrets

class ScrollDecorator extends Decorator{
    public ScrollDecorator(VisualComponent component){
        super(component);
    }

    public void draw(){
        addedBehaviour();
        super.draw();
    }

    private void addedBehaviour(){
        System.out.println("  ScrollDecorator.addedBehaviour()");
    }
}

class BorderDecorator extends Decorator{
    public BorderDecorator(VisualComponent component){
        super(component);
    }

    public void draw(){
        addedBehaviour();
        super.draw();
    }

    private void addedBehaviour(){
        System.out.println("  BorderDecorator.addedBehaviour()");
    }
}


/** Code client **/
public class ExempleGOF{
    public static void main(String[] args){
        System.out.println("=== c1 (pas de décoration) ===");
        VisualComponent c1 = new TextView();
        c1.draw();

        System.out.println("\n=== c2 (décoration par ScrollDecorator) ===");
        VisualComponent c2 = new ScrollDecorator(new TextView());
        c2.draw();

        System.out.println("\n=== c3 (décoration par BorderDecorator) ===");
        VisualComponent c3 = new BorderDecorator(new TextView());
        c3.draw();

        System.out.println("\n=== c4 (décoration par ScrollDecorator et BorderDecorator) ===");
        VisualComponent c4 = new ScrollDecorator(
                                new BorderDecorator(
                                    new TextView()));
        c4.draw();
    }
}

