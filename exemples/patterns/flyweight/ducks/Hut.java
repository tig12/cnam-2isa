
import java.awt.Graphics;

public class Hut implements Drawable{

    private int w, h; // width, height
    
    public Hut(int w, int h){
        this.w = w;
        this.h = h;
        System.out.println("creating Hut");
    }
    
    public void draw(Graphics g, int x, int y){
        g.drawRect(x, y, w, h);
        g.drawRect(x+1, y+1, w, h);
    }
    
}

