package maze.patterns.builder;

import maze.model.Maze;

// MazeGame is the Director of builder pattern
public class MazeGame{

    // création du jeu de l'énoncé
    public static Maze createMaze(MazeBuilder builder){
        builder.buildMaze();
        
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);
        
        return builder.getMaze();
    }
    
    // on peut facilement créer un autre jeu utilisant les mêmes composants
    public static Maze createComplexMaze(MazeBuilder builder){
        builder.buildMaze();
        
        builder.buildRoom(1);
        // ...
        builder.buildRoom(1000);

        return builder.getMaze();
    }

}