package dessin.carres;

import java.awt.Graphics;
import java.awt.Color;

/** 
    Ajoute des ronds bleus dessinés à chaque coin d'un carré simple.
**/
public class CarreRondsCoins extends CarreSimple{
    
    /** Couleur des ronds dessinés dans les coins **/
    private static Color color = Color.CYAN;
    
    /** Rayon des ronds dessinés dans les coins **/
    private static int radius = 20;

    public CarreRondsCoins(int xc, int yc, int cote){
        super(xc, yc, cote);
    }
    
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(color);
        int x, y;
        
        // top left
        x = getXc() - (int)(getCote() / 2.0) - (int)(radius / 2.0);
        y = getYc() - (int)(getCote() / 2.0) - (int)(radius / 2.0);
        g.drawOval(x, y, radius, radius);
        g.fillOval(x, y, radius, radius);
        
        // top right
        x = getXc() + (int)(getCote() / 2.0) - (int)(radius / 2.0);
        y = getYc() - (int)(getCote() / 2.0) - (int)(radius / 2.0);
        g.drawOval(x, y, radius, radius);
        g.fillOval(x, y, radius, radius);
        
        // bottom left
        x = getXc() - (int)(getCote() / 2.0) - (int)(radius / 2.0);
        y = getYc() + (int)(getCote() / 2.0) - (int)(radius / 2.0);
        g.drawOval(x, y, radius, radius);
        g.fillOval(x, y, radius, radius);
        
        // bottom right
        x = getXc() + (int)(getCote() / 2.0) - (int)(radius / 2.0);
        y = getYc() + (int)(getCote() / 2.0) - (int)(radius / 2.0);
        g.drawOval(x, y, radius, radius);
        g.fillOval(x, y, radius, radius);
    }
    
}
