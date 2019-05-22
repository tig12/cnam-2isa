/* 
Adaptation de http://zetcode.com/tutorials/javaswingtutorial/menusandtoolbars/

Dans cette version; le code à effectuer lors de exit a été mise dans la classe ExitAction.
*/

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingCommands2 extends JFrame {
    public static void main(String[] args) {
            var frame = new CommandFrame();
            frame.setVisible(true);
    }
}

class CommandFrame extends JFrame {

    public CommandFrame() {
        
        createMenuBar();
        
        createToolBar();
        
        setTitle("Simple menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        var menubar = new JMenuBar();

        var iconExit = new ImageIcon("img/exit-16.png");

        var fileMenu = new JMenu("File");
        var impMenu = new JMenu("Import");

        var newsMenuItem = new JMenuItem("Import newsfeed list...");
        var bookmarksMenuItem = new JMenuItem("Import bookmarks...");
        var importMailMenuItem = new JMenuItem("Import mail...");

        impMenu.add(newsMenuItem);
        impMenu.add(bookmarksMenuItem);
        impMenu.add(importMailMenuItem);

        var newMenuItem = new JMenuItem("New");
        var openMenuItem = new JMenuItem("Open");
        var saveMenuItem = new JMenuItem("Save");

        var exitMenuItem = new JMenuItem("Exit", iconExit);
        exitMenuItem.setToolTipText("Exit application");

        exitMenuItem.addActionListener(new ExitAction());

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(impMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menubar.add(fileMenu);

        setJMenuBar(menubar);
    }

    private void createToolBar() {
        var toolbar = new JToolBar();
        var icon = new ImageIcon("img/exit-32.png");

        var exitButton = new JButton(icon);
        toolbar.add(exitButton);

        exitButton.addActionListener(new ExitAction());

        add(toolbar, BorderLayout.NORTH);
    }
}

class ExitAction implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }
}