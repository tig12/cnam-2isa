
package maze.patterns.prototype;

import maze.model.*;

public class MazePrototypeFactory{

    protected Maze mazeProto;
    protected Wall wallProto;
    protected Room roomProto;
    protected Door doorProto;
    
    public MazePrototypeFactory(){
        this.mazeProto = new Maze();
        this.wallProto = new Wall();
        this.roomProto = new Room(0);
        this.doorProto = new Door(null, null);
    }
    
    public Maze makeMaze(){
        return mazeProto.clone();
    }

    public Room makeRoom(int n){
        Room result = roomProto.clone();
        result.setRoomNb(n);
        return result;
    }

    public Wall makeWall(){
        return wallProto.clone();
    }
    
    public Door makeDoor(Room r1, Room r2){
        Door result = doorProto.clone();
        result.setRooms(r1, r2);
        return result;
    }
    
}