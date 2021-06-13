
package maze.patterns.prototype;

import maze.model.*;
import maze.model.bomb.*;

public class BombedMazePrototypeFactory extends MazePrototypeFactory {

    protected BombedWall wallProto;
    protected RoomWithBomb roomProto;
    
    public BombedMazePrototypeFactory(){
        this.wallProto = new BombedWall();
        this.roomProto = new RoomWithBomb(0);
    }
    
}
