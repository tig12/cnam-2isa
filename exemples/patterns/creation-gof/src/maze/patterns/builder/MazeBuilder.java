package maze.patterns.builder;

import maze.model.Maze;

/** 
    Superclasse des builders concrets
    Pourrait être une classe abstraite ou une interface
    Des méthodes vides sont fournies "pour laisser aux classes dérivées 
    la possibilité de n'overrider que les méthodes dont elles ont besoin" (gof)
**/
public class MazeBuilder{

    public void buildMaze(){}
    public void buildRoom(int roomNb){}
    public void buildDoor(int roomFrom, int roomTo){}
    
    public Maze getMaze(){
        return new Maze(); // bouchon
    }
    
}
