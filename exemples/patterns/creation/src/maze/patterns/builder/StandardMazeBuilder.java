package maze.patterns.builder;

import maze.model.*;
import static maze.model.Direction.*;

public class StandardMazeBuilder extends MazeBuilder{
    
    private Maze _currentMaze;
        
    public Maze getMaze(){
        return _currentMaze;
    }
    
    public void buildMaze(){
        _currentMaze = new Maze();
    }
    
    public void buildRoom(int roomNb){
        if(_currentMaze.roomNo(roomNb) == null){
            Room room = new Room(roomNb);
            _currentMaze.addRoom(room);
            room.setSide(NORTH, new Wall());
            room.setSide(EAST, new Wall());    
            room.setSide(SOUTH, new Wall());
            room.setSide(WEST, new Wall());
        }
    }
    
    public void buildDoor(int roomFrom, int roomTo){  
        Room r1 = _currentMaze.roomNo(roomFrom);
        Room r2 = _currentMaze.roomNo(roomTo);
        Door d = new Door(r1, r2);
        r1.setSide(commonWall(r1, r2), d);
        r2.setSide(commonWall(r2, r1), d);
    }
    
    /** 
        Indique la direction d'un mur commun entre deux pièces
    **/
    private Direction commonWall(Room r1, Room r2){
        return NORTH; // bouchon
    }
    
}
