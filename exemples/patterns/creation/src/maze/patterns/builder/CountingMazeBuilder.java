package maze.patterns.builder;

import maze.model.Maze;

/** 
    Builder qui ne fait que compter les portes et les pièces
**/
public class CountingMazeBuilder extends MazeBuilder{

    int _rooms = 0, _doors = 0;
    
    public void buildMaze(){
    }
    
    public void buildRoom(int roomNb){
        _rooms++;
    }
    
    public void buildDoor(int roomFrom, int roomTo){
        _doors++;
    }
    
    public int getRoomCount(){
        return _rooms;
    }
    
    public int getDoorCount(){
        return _doors;
    }
    
}
