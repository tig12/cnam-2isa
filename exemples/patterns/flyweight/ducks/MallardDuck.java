
import java.awt.Graphics;
import java.awt.Color;

public class MallardDuck implements Drawable{
    
    // état intrinsèque, commun à tous les canards de cette espèce
    private static Color color = Color.GREEN;
    private static int radius = 10; // rayon du cercle représentant cette espèce
    
    public MallardDuck(){
        System.out.println("creating MallardDuck");
    }
    
    public void draw(Graphics g, int x, int y){
        g.setColor(color);
        g.drawOval(x, y, radius, radius);
        g.fillOval(x, y, radius, radius);        
    }
    
}
