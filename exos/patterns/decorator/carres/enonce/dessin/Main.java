package dessin;

import dessin.carres.*;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Dessin de carrés");
        JPanel contentPane = new DessinPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
    
}

/** 
    Panel où les carrés sont dessinés
**/
class DessinPanel extends JPanel{
    
    public void paint(Graphics g){
        
        // au centre
        CarreSimple c1 = new CarreSimple(500, 500, 100);
        c1.draw(g);
        
        // en haut à gauche
        CarreRondsCoins c2 = new CarreRondsCoins(200, 200, 100);
        c2.draw(g);
        
        // en bas à gauche
        CarreDoubleBordure c3 = new CarreDoubleBordure(200, 800, 100);
        c3.draw(g);
        
        // en haut à droite
        CarreCentre c4 = new CarreCentre(800, 200, 100);
        c4.draw(g);
        
        // en bas à droite
        CarreMarqueMilieu c5 = new CarreMarqueMilieu(800, 800, 100);
        c5.draw(g);
    }
}


