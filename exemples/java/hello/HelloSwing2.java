import javax.swing.*;

public class HelloSwing2 extends JFrame {

    public static void main(String argv[]) {
        HelloSwing2 helloSwing = new HelloSwing2();
    }
    
    public HelloSwing2(){
        setTitle("Hello Swing");
        
        JPanel contentPane = new JPanel();
        
        JTextArea text = new JTextArea("Hello swing 2");
        contentPane.add(text);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setSize(300,100);
        setVisible(true);
    
    }
        
}