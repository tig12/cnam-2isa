package maze.patterns.factorymethod;

import maze.model.*;
import maze.model.bomb.*;

public class BombedMazeGame extends MazeGame{

    // factory methods
    
//    @Override
    public static Room makeRoom(int n){
        return new RoomWithBomb(n);
    }

//    @Override
    public static Wall makeWall(){
        return new BombedWall();
    }
    
}
