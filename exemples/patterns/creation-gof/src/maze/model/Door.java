package maze.model;

/** 
    Une <code>Door</code> relie 2 <code>Room</code>s
**/
public class Door extends MapSite{
    
    private Room r1;
    private Room r2;
    private boolean isOpen;
    
    public Door(Room r1, Room r2){
        this.r1 = r1;
        this.r2 = r2;
    }
    
    public void enter(){
    }
    
    public Room otherSideFrom(Room room){
        return new Room(0); // bouchon pour pouvoir compiler
    }
    
    // ========= utilisé uniquement par prototype =========
    public Door clone(){
        return this;
    }
    
    public void setRooms(Room r1, Room r2){
        this.r1 = r1;
        this.r2 = r2;
    }
    
}