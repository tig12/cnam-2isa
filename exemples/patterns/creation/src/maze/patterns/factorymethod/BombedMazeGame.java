package maze.patterns.factorymethod;

import maze.model.*;
import maze.model.bomb.*;

public class BombedMazeGame extends MazeGame{

    // factory methods
    
    public static Room makeRoom(int n){
        return new RoomWithBomb(n);
    }

    public static Wall makeWall(){
        return new BombedWall();
    }
    
}
