package maze.patterns.factorymethod;

import maze.model.*;
import static maze.model.Direction.*;

public class MazeGame{

    public static Maze createMaze(){
    
        Maze aMaze = makeMaze();
        Room r1 = makeRoom(1);
        Room r2 = makeRoom(2);
        Door aDoor = makeDoor(r1, r2);
        
        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        
        r1.setSide(NORTH, makeWall());
        r1.setSide(EAST, aDoor);
        r1.setSide(SOUTH, makeWall());
        r1.setSide(WEST, makeWall());
        
        r2.setSide(NORTH, makeWall());
        r2.setSide(EAST, makeWall());
        r2.setSide(SOUTH, makeWall());
        r2.setSide(WEST, aDoor);
        
        return aMaze;
    }
    
    // factory methods qui peuvent être overridées
    
    public static Maze makeMaze(){
        return new Maze();
    }

    public static Room makeRoom(int n){
        return new Room(n);
    }

    public static Wall makeWall(){
        return new Wall();
    }
    
    public static Door makeDoor(Room r1, Room r2){
        return new Door(r1, r2);
    }

}
