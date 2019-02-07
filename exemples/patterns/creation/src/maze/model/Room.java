package maze.model;

public class Room extends MapSite{
    
    private int roomNb;
    
    private MapSite[] sides;
    
    public Room(int roomNb){
        this.roomNb = roomNb;
        this.sides = new MapSite[4];
    }
    
    public void enter(){
    }
    
    public MapSite getSide(Direction dir){
        return new Room(0); // bouchon pour pouvoir compiler
    }
    
    public void setSide(Direction dir, MapSite mapSite){
    }
    
    @Override
    public String toString(){
        return "room " + this.roomNb;
    }
    
    // ========= utilisé uniquement par prototype =========
    public Room clone(){
        return this;
    }
    
    public void setRoomNb(int n){
        this.roomNb = n;
    }
    
}