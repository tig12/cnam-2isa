package maze.patterns.factorymethod;

import maze.model.*;
import maze.model.enchanted.*;

public class EnchantedMazeGame extends MazeGame{

    // factory methods
    
//    @Override
    public static Room makeRoom(int n){
        return new EnchantedRoom(n);
    }

//    @Override
    public static Door makeDoor(Room r1, Room r2){
        return new DoorNeedingSpell(r1, r2);
    }
    
}
