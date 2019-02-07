
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/** 
    Client
**/
public class Main {                                             
    
    // drawables et leurs coordonnées- etat extrinsèque
    public static List<Drawable> drawables = new ArrayList<Drawable>();
    public static List<Integer> xs = new ArrayList<Integer>();
    public static List<Integer> ys = new ArrayList<Integer>();
    
    // taile de la carte
    private static double mapWidth = 600, mapHeight = 600;
    private static int gap = 30;    

         
    public static void main(String[] args) {
        
        // Création des drawables
        // huttes
        drawables.add(DrawableFactory.getHut(30, 40));                                                                   
        xs.add(new Integer(150));
        ys.add(new Integer(180));
        drawables.add(DrawableFactory.getHut(50, 70));                                                                   
        xs.add(new Integer(500));
        ys.add(new Integer(400));
        // canards
        int x, y;
        for(int i=0; i < 30; i++){
            drawables.add(DrawableFactory.getMallardDuck());
            x = (int)(Math.random() * (mapWidth - 2*gap)) + gap;
            y = (int)(Math.random() * (mapHeight - 2*gap)) + gap;
            xs.add(new Integer(x));
            ys.add(new Integer(y));
        }
        for(int i=0; i < 15; i++){
            drawables.add(DrawableFactory.getRedheadDuck());
            x = (int)(Math.random() * (mapWidth - gap));
            y = (int)(Math.random() * (mapHeight - gap));
            xs.add(new Integer(x));
            ys.add(new Integer(y));
        }
        
        // Création de l'UI
        JFrame frame = new JFrame("Duck flyweight");
        
        JPanel contentPane = new MapPanel();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}

/** 
    Panel représentant la carte du parc ornithologique
**/
class MapPanel extends JPanel{
    
    public void paint(Graphics g){
        for(int i=0; i < Main.drawables.size(); i++){
            Main.drawables.get(i).draw(g, Main.xs.get(i).intValue(), Main.ys.get(i).intValue());
        }
        
    }
}

