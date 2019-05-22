/* 
Adaptation de http://zetcode.com/tutorials/javaswingtutorial/menusandtoolbars/

Version originale, sans pattern Command explicite :
L'implémentation de l'action à effectuer lorsqu'on quitte
doit être répétée dans le listenner du menu et dans le listener de la toolbar :
    exitMenuItem.addActionListener((event) -> System.exit(0));
    exitButton.addActionListener((e) -> System.exit(0));
*/

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

public class SwingCommands1 {
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

        exitMenuItem.addActionListener((event) -> System.exit(0));

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

        exitButton.addActionListener((e) -> System.exit(0));

        add(toolbar, BorderLayout.NORTH);
    }
}
