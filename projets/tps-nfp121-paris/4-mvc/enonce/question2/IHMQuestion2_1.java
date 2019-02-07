package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_1 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);

 
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // à compléter
        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3

        // le bouton B a 2 observateurs jbo1 et jbo2

        // le bouton C a 1 observateur jbo1

      
    }
    
    public static void main(String[] args){
        new IHMQuestion2_1();
    }

}
