package dessin.carres;

import java.awt.Graphics;
import java.awt.Color;

/** 
    Ajoute une petite croix au centre d'un carré simple.
**/
public class CarreCentre extends CarreSimple{
    
    /** Couleur utilisée pour dessiner la croix **/
    private static Color color = Color.BLACK;
    
    /** Taille de la croix dessinées au centre **/
    private static int tailleCroix = 5;

    public CarreCentre(int xc, int yc, int cote){
        super(xc, yc, cote);
    }
    
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(color);
        g.drawLine(getXc() - tailleCroix, getYc(), getXc() + tailleCroix, getYc());
        g.drawLine(getXc(), getYc() - tailleCroix, getXc(), getYc() + tailleCroix);
    }
    
}
