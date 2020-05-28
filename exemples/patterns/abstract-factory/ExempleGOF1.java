/** 
    Implémentation de l'exemple GOF
    (look and feels PM et Motif remplacés par Linux et Mac)
**/

// ====== abstract factory ======
class WidgetFactory{
    public AbstractWindow createWindow(){ return new AbstractWindow(); }
    public AbstractScrollBar createScrollBar(){ return new AbstractScrollBar(); }
}

// ====== concrete factories ======
class LinuxFactory extends WidgetFactory{
    public AbstractWindow createWindow(){ return new LinuxWindow(); }
    public AbstractScrollBar createScrollBar(){ return new LinuxScrollBar(); }
}

class MacFactory extends WidgetFactory{
    public AbstractWindow createWindow(){ return new MacWindow(); }
    public AbstractScrollBar createScrollBar(){ return new MacScrollBar(); }
}

// ====== abstract products ======
class AbstractWindow{
    @Override public String toString(){ return this.getClass().getName(); }
}
class AbstractScrollBar{
    @Override public String toString(){ return this.getClass().getName(); }
}

// ====== concrete products ======
class LinuxWindow extends AbstractWindow{}
class LinuxScrollBar extends AbstractScrollBar{}

class MacWindow extends AbstractWindow{}
class MacScrollBar extends AbstractScrollBar{}

// ====== client ======
public class ExempleGOF1{
    public static void main(String[] args){
        
        AbstractWindow myWindow;
        AbstractScrollBar myScroll;
        
        WidgetFactory factory1 = new LinuxFactory();
        myWindow = factory1.createWindow();
        myScroll = factory1.createScrollBar();
        System.out.println("\n=== LinuxFactory ===");
        System.out.println("    Window : " + myWindow);
        System.out.println("    ScrollBar : " + myScroll);
        
        WidgetFactory factory2 = new MacFactory();
        myWindow = factory2.createWindow();
        myScroll = factory2.createScrollBar();
        System.out.println("\n=== MacFactory ===");
        System.out.println("    Window : " + myWindow);
        System.out.println("    ScrollBar : " + myScroll);
    }
}

