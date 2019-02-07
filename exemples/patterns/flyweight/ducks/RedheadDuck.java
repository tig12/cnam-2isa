
import java.awt.Graphics;
import java.awt.Color;

public class RedheadDuck implements Drawable{

    // état intrinsèque, commun à tous les canards de cette espèce
    private static Color color = Color.RED;
    private static int radius = 15; // rayon du cercle représentant cette espèce
    
    public RedheadDuck(){
        System.out.println("creating RedheadDuck");
    }
    
    public void draw(Graphics g, int x, int y){
        g.setColor(color);
        g.drawOval(x, y, radius, radius);
        g.fillOval(x, y, radius, radius);
    }
    
}

