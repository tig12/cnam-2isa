package maze.patterns.prototype;

import maze.model.*;
import static maze.model.Direction.*;

public class MazeGame{

    public static Maze createMaze(MazePrototypeFactory factory){
        Maze aMaze = factory.makeMaze();
        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);
        Door aDoor = factory.makeDoor(r1, r2);
        
        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        
        r1.setSide(NORTH, factory.makeWall());
        r1.setSide(EAST, aDoor);
        r1.setSide(SOUTH, factory.makeWall());
        r1.setSide(WEST, factory.makeWall());
        
        r2.setSide(NORTH, factory.makeWall());
        r2.setSide(EAST, factory.makeWall());
        r2.setSide(SOUTH, factory.makeWall());
        r2.setSide(WEST, aDoor);
        
        return aMaze;
    }
}
