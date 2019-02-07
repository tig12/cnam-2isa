import java.awt.*;
import javax.swing.*;

class Swing{
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Exemple composite");
        JPanel contentPane = new JPanel();
        
        contentPane.add(new JTextArea("Leaf1"));
        
        JPanel panel1 = new JPanel();
        panel1.add(new JButton("A"));
        panel1.add(new JButton("B"));
        
        JPanel panel2 = new JPanel();
        panel2.add(new JButton("C"));
        panel2.add(new JButton("D"));
        panel1.add(panel2);
        
        contentPane.add(panel1);
        
        frame.setContentPane(contentPane);
        frame.setSize(300,100);
        frame.pack();
        frame.setVisible(true);
    }
}
