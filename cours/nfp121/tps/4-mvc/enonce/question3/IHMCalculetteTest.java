package question3;

import java.awt.Robot;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.StringTokenizer;
import java.util.Random;


import java.applet.*;
import java.beans.*;
import java.net.*;
import java.io.*;

public class IHMCalculetteTest extends junit.framework.TestCase{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    private JFrame f;
    private Robot robot;
    private static Random random= new Random();

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() throws java.lang.Exception{
        try{

            f = new IHMCalculette();
            f.pack();
            f.setVisible(true);
            while(!(f.isShowing())){}
            f.setAlwaysOnTop(true);
            f.setLocation(random.nextInt(500), random.nextInt(500));
            robot = new Robot();
            robot.delay(10);

        }catch(Exception e){
            fail("exception inattendue !, " + e.getClass().getName());
        }
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown(){ // throws java.lang.Exception
        f.dispose();
    }

    public void test_IHMCalculette_addition() throws Exception{
        try{
            Container panel = f.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals(" ce n'est pas l'IHM attendue ?", 2, components.length);

            // la bonne IHM
            assertTrue(components[0] instanceof JPanel);
            Component[] vue = ((JPanel)components[0]).getComponents();
            JLabel etatPile = ((JLabel)vue[0]);

            assertTrue(components[1] instanceof JPanel);
            Component[] controle = ((JPanel)components[1]).getComponents();
            assertEquals(" ce n'est pas l'IHM attendue ?", 2, controle.length);

            assertTrue(" ce n'est pas l'IHM attendue ?", controle[0] instanceof JTextField);
            Component[] subComponents = ((JPanel)controle[1]).getComponents();
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[0] instanceof JButton);// push
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[1] instanceof JButton);// +
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[2] instanceof JButton);// -
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[3] instanceof JButton);// *
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[4] instanceof JButton);// /

            empiler("15");
            assertTrue("empiler(15), en sortie != [15]","[15]".equals(etatPile.getText()));
            empiler("12");
            assertTrue("empiler(15),empiler(12) en sortie != [12, 15]","[12, 15]".equals(etatPile.getText()));
            assertTrue("15+12 != 27 ???","[27]".equals(add()));
            empiler("12");
            assertTrue("[12, 27]".equals(etatPile.getText()));
            assertTrue("27 + 12 != 39 ??? ","[39]".equals(add()));
        }catch(Exception e){
            fail("exception inattendue ! " + e.getClass().getName());
        }
    }

  

    public void test_IHMCalculette_soustraction() throws Exception{
        try{
            Container panel = f.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals(" ce n'est pas l'IHM attendue ?", 2, components.length);

            // la bonne IHM
            assertTrue(components[0] instanceof JPanel);
            Component[] vue = ((JPanel)components[0]).getComponents();
            JLabel etatPile = ((JLabel)vue[0]);

            assertTrue(components[1] instanceof JPanel);
            Component[] controle = ((JPanel)components[1]).getComponents();
            assertEquals(" ce n'est pas l'IHM attendue ?", 2, controle.length);

            assertTrue(" ce n'est pas l'IHM attendue ?", controle[0] instanceof JTextField);
            Component[] subComponents = ((JPanel)controle[1]).getComponents();
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[0] instanceof JButton);// push
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[1] instanceof JButton);// +
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[2] instanceof JButton);// -
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[3] instanceof JButton);// *
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[4] instanceof JButton);// /

            empiler("32");
            assertTrue("empiler(32), en sortie != [32]","[32]".equals(etatPile.getText()));
            empiler("10");
            assertTrue("empiler(32),empiler(10) en sortie != [10, 32]","[10, 32]".equals(etatPile.getText()));
            assertTrue(" 32-10 != 22 ???","[22]".equals(sub()));
        }catch(Exception e){
            fail("exception inattendue ! " + e.getClass().getName());
        }
    }

   
	
    public void test_IHMCalculette_MauvaisFormatDuNombre() throws Exception{
        try{
            Container panel = f.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals(" ce n'est pas l'IHM attendue ?", 2, components.length);

            // la bonne IHM
            assertTrue(" ce n'est pas l'IHM attendue ?", components[0] instanceof JPanel);
            Component[] vue = ((JPanel)components[0]).getComponents();
            JLabel etatPile = ((JLabel)vue[0]);

            assertTrue(" ce n'est pas l'IHM attendue ?", components[1] instanceof JPanel);
            Component[] controle = ((JPanel)components[1]).getComponents();
            assertEquals(" ce n'est pas l'IHM attendue ?", 2, controle.length);

            assertTrue(controle[0] instanceof JTextField);
            Component[] subComponents = ((JPanel)controle[1]).getComponents();
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[0] instanceof JButton);// push
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[1] instanceof JButton);// +
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[2] instanceof JButton);// -
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[3] instanceof JButton);// *
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[4] instanceof JButton);// /

            empiler("32");
            assertTrue("[32]".equals(etatPile.getText()));
            empiler("AA");
            assertTrue("incidence sur la pile d'évaluation ???", "[32]".equals(etatPile.getText()));
            empiler("32");
            assertTrue("incidence sur la pile d'évaluation ???","[32, 32]".equals(etatPile.getText()));
        }catch(Exception e){
            fail("exception inattendue ! " + e.getClass().getName());
        }
    }

   

    public void test_IHMCalculette_division() throws Exception{
        try{
            Container panel = f.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals(" ce n'est pas l'IHM attendue ?", 2, components.length);

            // la bonne IHM
            assertTrue(" ce n'est pas l'IHM attendue ?", components[0] instanceof JPanel);
            Component[] vue = ((JPanel)components[0]).getComponents();
            JLabel etatPile = ((JLabel)vue[0]);

            assertTrue(" ce n'est pas l'IHM attendue ?", components[1] instanceof JPanel);
            Component[] controle = ((JPanel)components[1]).getComponents();
            assertEquals(" ce n'est pas l'IHM attendue ?", 2, controle.length);

            assertTrue(" ce n'est pas l'IHM attendue ?", controle[0] instanceof JTextField);
            Component[] subComponents = ((JPanel)controle[1]).getComponents();
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[0] instanceof JButton);// push
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[1] instanceof JButton);// +
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[2] instanceof JButton);// -
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[3] instanceof JButton);// *
            assertTrue(" ce n'est pas l'IHM attendue ?", subComponents[4] instanceof JButton);// /

            empiler("32");
            empiler("2");
            Point location = subComponents[4].getLocationOnScreen();
            mouseMoveAndClick(location.x,location.y);
            assertTrue(" 32/2 != 16 ???","[16]".equals(etatPile.getText()));
        }catch(Exception e){
            fail("exception inattendue ! " + e.getClass().getName());
        }
    }

   

    private void empiler(String str) throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] controle = ((JPanel)components[1]).getComponents();
        Component[] subComponents = ((JPanel)controle[1]).getComponents();

        Point location = controle[0].getLocationOnScreen();
        mouseMoveAndClickClick(location.x,location.y);
        typeLine(str, robot, false);

        location = subComponents[0].getLocationOnScreen();
        mouseMoveAndClick(location.x+(subComponents[0].getWidth()/2),location.y+(subComponents[0].getHeight()/2));
    }

    private String add(){
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] controle = ((JPanel)components[1]).getComponents();
        Component[] subComponents = ((JPanel)controle[1]).getComponents();
        Component[] vue = ((JPanel)components[0]).getComponents();
        JLabel etatPile = ((JLabel)vue[0]);

        Point location = subComponents[1].getLocationOnScreen();
        mouseMoveAndClick(location.x+(subComponents[1].getWidth()/2),location.y+(subComponents[1].getHeight()/2));

        return etatPile.getText();

    }

    private String sub(){
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] controle = ((JPanel)components[1]).getComponents();
        Component[] subComponents = ((JPanel)controle[1]).getComponents();
        Component[] vue = ((JPanel)components[0]).getComponents();
        JLabel etatPile = ((JLabel)vue[0]);

        Point location = subComponents[2].getLocationOnScreen();
        mouseMoveAndClick(location.x+(subComponents[2].getWidth()/2),location.y+(subComponents[2].getHeight()/2));

        return etatPile.getText();

    }

    // extrait de http://www.hazirkod.com/hazirkodv.asp?KID=1425
    public static void typeLine(String s, Robot robot, boolean enter) throws Exception{
        char[] array=s.toCharArray();
        for(int i=0;i<array.length;i++){

            if(array[i]>='a'&&array[i]<='z'){
                robot.keyPress((int)array[i]-(int)'a'+65);
                robot.delay(10);
                robot.keyRelease((int)array[i]-(int)'a'+65);
            }else if(array[i]==' '){
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.delay(10);
                robot.keyRelease(KeyEvent.VK_SPACE);
            }else if(array[i]=='-'){
                robot.keyPress(KeyEvent.VK_SUBTRACT);
                robot.delay(10);
                robot.keyRelease(KeyEvent.VK_SUBTRACT);
            }else if(array[i]=='+'){
                robot.keyPress(KeyEvent.VK_ADD);
                robot.delay(10);
                robot.keyRelease(KeyEvent.VK_ADD);
            }else if(array[i]>='A'&&array[i]<='Z'){
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress((int)array[i]-(int)'A'+65);
                robot.delay(10);
                robot.keyRelease((int)array[i]-(int)'A'+65);
                robot.delay(10);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }else if(array[i]>='0'&&array[i]<='9'){
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.delay(10);
                robot.keyPress(KeyEvent.VK_0+(int)(array[i]-'0'));
                robot.delay(10);
                robot.keyRelease(KeyEvent.VK_0+(int)(array[i]-'0'));
                robot.delay(10);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            robot.delay(10);
        }
    }

    public void mouseMoveAndClick(int x, int y){
        robot.mouseMove( x,y);
        robot.delay(20);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(20);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(20);
    }//end mouseMoveAndClick

    public void mouseMoveAndClickClick(int x, int y){
        robot.mouseMove( x,y);
        robot.delay(10);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(10);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(10);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(10);
    }//end mouseMoveAndClickClick

  
}
