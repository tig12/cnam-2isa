import javax.swing.Box;
import java.awt.Dimension;

/** 
    Réponse à la question 2 e de https://docs.oracle.com/javase/tutorial/java/javaOO/QandE/nested-questions.html
**/
class Question2{
    public static void main(String[] args){
        Box.Filler b = new Box.Filler(
            new Dimension(100, 100),
            new Dimension(150, 150),
            new Dimension(200, 200)
        );
    }
}
