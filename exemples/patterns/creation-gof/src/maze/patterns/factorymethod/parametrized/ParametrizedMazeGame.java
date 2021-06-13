
// variante paramétrée de factory method

package maze.patterns.factorymethod.parametrized;

import maze.model.*;
import maze.patterns.factorymethod.*;

public class ParametrizedMazeGame{

    public static Maze doCreateMaze(String gameId){
        Maze maze = null;
        switch(gameId){
        	case "standard"    : maze = MazeGame.createMaze(); break;
        	case "bombed"      : maze = BombedMazeGame.createMaze(); break;
        	case "enchanted"   : maze = EnchantedMazeGame.createMaze(); break;
        }
        return maze;
    }
}
