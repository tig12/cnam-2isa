package maze.model;

//import java.util.List;
//import java.util.ArrayList;

public class Maze{
    
    //List<Room> rooms = new ArrayList<>();
    
    public void addRoom(Room room){
        //rooms.add(room);
    }
    
    
    /** Pourrait s'appeler getRoomFromNumber() **/
    public Room roomNo(int roomNumber){
        return new Room(0); // bouchon pour pouvoir compiler
    }

    @Override
    public String toString(){
        return "maze.model.Maze";
        //StringBuffer res = "Maze";
        //for(Room r : rooms){
        //    res.append(r.toString());
        //}
    }
    
    // ========= utilisé uniquement par prototype =========
    public Maze clone(){
        return this;
    }
}
