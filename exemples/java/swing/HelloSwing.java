import javax.swing.*;

public class HelloSwing {

    public static void main(String argv[]) {
        JFrame frame = new JFrame("Hello Swing");
        
        JPanel contentPane = new JPanel();
        
        JTextArea text = new JTextArea("Hello swing");
        contentPane.add(text);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setSize(300,100);
        frame.setVisible(true);
    }
    
}