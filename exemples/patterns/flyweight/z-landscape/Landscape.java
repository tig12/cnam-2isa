
/** 
    Implémentation de l'exemple Head First p 618 en utilisant swing.
    @history 2018-01-14 02:13:13+01:00 Thierry Graff : création
**/

import javax.swing.*;
import java.awt.*;

public class Landscape {                                             
 
    public static void main(String argv[]) {
        JFrame frame = new JFrame("Exemple Swing 1");
        
        JPanel contentPane = new LandscapePane();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}

class LandscapePane extends JPanel{
    
    public void paint(Graphics g){
        //this.setBackground(Color.GREEN);
        TreeManager.displayTrees(g);
    }
}


class TreeManager{

    // les états externes des objets fictifs
    private static int[][] states = {
        // {x, y, age}
        {300, 135, 6},
        {100, 35, 12},
        {400, 335, 20},
    };

    public static void displayTrees(Graphics g){
        int x, y, age, r;
        for(int[] state : states){
            x = state[0];
            y = state[1];
            age = state[2];
            r = radius(x, y, age);
            g.drawOval(x, y, r, r);
        }
    }
    
    private static int radius(int x, int y, int age){
        return 3 * age;
    }
    
}

