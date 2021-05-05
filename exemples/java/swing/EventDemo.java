import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventDemo extends JFrame implements ActionListener{
    
    public static void main(String[] args){
        new EventDemo();
    }
    
    private JTextField donnee = new JTextField(20);
    private JLabel     affichage = new JLabel("Ici un JLabel");

    public EventDemo(){
        super("Event demo");
        JButton    btnAffiche = new JButton("Afficher");
        JButton    btnEfface = new JButton("Effacer");

        JPanel milieu = new JPanel();
        milieu.add(btnAffiche);
        milieu.add(btnEfface);
        milieu.setBackground(Color.lightGray);
        
        setLayout(new BorderLayout(5,5));
        
        add("North", donnee);
        add("Center", milieu);
        add("South", affichage);
        
        Font font = new Font("Monaco", Font.PLAIN, 36);
        donnee.setFont(font);
        milieu.setFont(font);
        affichage.setFont(font);
        btnAffiche.setFont(font);
        btnEfface.setFont(font);
        
        setLocation(100,100);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnAffiche.addActionListener(this);
        btnEfface.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Afficher")){
            affichage.setText(donnee.getText());
        }
        else if(ae.getActionCommand().equals("Effacer")){
            affichage.setText(" ");
        }
    }

}
