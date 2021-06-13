package maze.patterns.abstractfactory;

import maze.model.*;
import maze.model.bomb.*;

public class BombedMazeFactory extends MazeFactory{
    
    public static Room makeRoom(int n){
        return new RoomWithBomb(n);
    }

    public static Wall makeWall(){
        return new BombedWall();
    }
    
}
