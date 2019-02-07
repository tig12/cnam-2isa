package maze.patterns.abstractfactory;

import maze.model.*;
import maze.model.enchanted.*;

public class EnchantedMazeFactory extends MazeFactory{
    
    public static Room makeRoom(int n){
        return new EnchantedRoom(n);
    }
    
    // inutile
    public static Door makeDoor(Room r1, Room r2){
        return new Door(r1, r2);
    }

}
