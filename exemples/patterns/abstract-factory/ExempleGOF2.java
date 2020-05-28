/** 
    Implémentation de l'exemple GOF en utilisant des interfaces
    (look and feels PM et Motif remplacés par Linux et Mac)
**/

// ====== abstract factory ======
interface WidgetFactory{
    public AbstractWindow createWindow();
    public AbstractScrollBar createScrollBar();
}

// ====== concrete factories ======
class LinuxFactory implements WidgetFactory{
    public AbstractWindow createWindow(){ return new LinuxWindow(); }
    public AbstractScrollBar createScrollBar(){ return new LinuxScrollBar(); }
}

class MacFactory implements WidgetFactory{
    public AbstractWindow createWindow(){ return new MacWindow(); }
    public AbstractScrollBar createScrollBar(){ return new MacScrollBar(); }
}

// ====== abstract products ======
interface AbstractWindow{}
interface AbstractScrollBar{}

// ====== concrete products ======
class LinuxWindow implements AbstractWindow{}
class LinuxScrollBar implements AbstractScrollBar{}

class MacWindow implements AbstractWindow{}
class MacScrollBar implements AbstractScrollBar{}

// ====== client ======
public class ExempleGOF2{
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

