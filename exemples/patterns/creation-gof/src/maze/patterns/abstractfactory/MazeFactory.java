package maze.patterns.abstractfactory;

import maze.model.*;

public class MazeFactory{
    
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
