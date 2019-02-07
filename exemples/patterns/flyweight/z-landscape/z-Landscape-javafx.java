
/** 
    
    Tentative ratée d'implémenter un flyweight avec javafx
    Implémentation de l'exemple Head First p 618
    Problème : dès que TreeManager.trees contient plus d'une ligne :
        java.lang.reflect.InvocationTargetException
        Caused by: java.lang.RuntimeException: Exception in Application start method
        Caused by: java.lang.IllegalArgumentException: Children: duplicate children added: parent = Group@289e62e    

    @history 2018-01-14 02:09:25+01:00 Thierry Graff : création
**/
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.shape.Circle; 
import javafx.scene.paint.Color;

public class Landscape extends Application {                                             
 
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        

        Group root = new Group();
        TreeManager.displayTrees(root);
        Scene scene = new Scene(root, 800, 600, Color. 	LIGHTSTEELBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


class TreeManager{
    
    // le seul objet créé
    private static Circle circle = new Circle();
    
    // les états externes des objets fictifs
    private static float[][] trees = {
        {300.0f, 135.0f, 6.0f},
    };

    public static void displayTrees(Group group){
        float x, y, age, r;
        for(float[] tree : trees){
            x = tree[0];
            y = tree[1];
            age = tree[2];
            r = radius(x, y, age);
            circle.setCenterX(300.0f); 
            circle.setCenterY(135.0f); 
            circle.setRadius(100.0f);
            group.getChildren().add(circle);
        }
    }
    
    private static float radius(float x, float y, float age){
        return 5 * age;
    }
    
}


class Tree{
    static void display(float x, float y, float age){
    }
}