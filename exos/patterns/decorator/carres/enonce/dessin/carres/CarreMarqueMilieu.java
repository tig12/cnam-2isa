package dessin.carres;

import java.awt.Graphics;
import java.awt.Color;

/** 
    Ajoute un petit rectangle rouge au milieu de chaque côté d'un carré simple.
**/
public class CarreMarqueMilieu extends CarreSimple{
    
    /** Couleur des rectangles dessinés sur chaque côté **/
    private static Color color = Color.RED;
    
    /** Largeur de la marque dessinée sur les côtés **/
    private static int largeurMarque = 4;

    /** Longueur de la marque dessinée sur les côtés **/
    private static int longueurMarque = 20;

    public CarreMarqueMilieu(int xc, int yc, int cote){
        super(xc, yc, cote);
    }
    
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(color);
        int x, y;
        
        // top
        x = getXc() - (int)(largeurMarque / 2.0);
        y = getYc() - (int)(getCote() / 2.0) - (int)(longueurMarque / 2.0);
        g.drawRect(x, y, largeurMarque, longueurMarque);
        g.fillRect(x, y, largeurMarque, longueurMarque);
        
        // bottom
        x = getXc() - (int)(largeurMarque / 2.0);
        y = getYc() + (int)(getCote() / 2.0) - (int)(longueurMarque / 2.0);
        g.drawRect(x, y, largeurMarque, longueurMarque);
        g.fillRect(x, y, largeurMarque, longueurMarque);
        
        // left
        x = getXc() - (int)(getCote() / 2.0) - (int)(longueurMarque / 2.0);
        y = getYc() - (int)(largeurMarque / 2.0);
        g.drawRect(x, y, longueurMarque, largeurMarque);
        g.fillRect(x, y, longueurMarque, largeurMarque);
        
        // right
        x = getXc() + (int)(getCote() / 2.0) - (int)(longueurMarque / 2.0);
        y = getYc() - (int)(largeurMarque / 2.0);
        g.drawRect(x, y, longueurMarque, largeurMarque);
        g.fillRect(x, y, longueurMarque, largeurMarque);
    }
}
