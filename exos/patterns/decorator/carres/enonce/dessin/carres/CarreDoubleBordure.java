package dessin.carres;

import java.awt.Graphics;
import java.awt.Color;

/** 
    Ajoute une bordure intérieure à un carré simple.
**/
public class CarreDoubleBordure extends CarreSimple{
    
    /** Couleur utilisée pour dessiner la bordure supplémentaire **/
    private static Color color = Color.GRAY;
    
    /** Distance entre la bordure intérieur et extérieure, en pixels **/
    private static int delta = 5;

    public CarreDoubleBordure(int xc, int yc, int cote){
        super(xc, yc, cote);
    }
    
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(color);
        int x, y;
        
        x = getXc() - (int)(getCote() / 2.0) + delta;
        y = getYc() - (int)(getCote() / 2.0) + delta;
        g.drawRect(x, y, getCote() - 2*delta, getCote() - 2*delta);
    }
    
}
