
package maze.patterns.prototype;

import maze.model.*;
import maze.model.enchanted.*;

public class EnchantedMazePrototypeFactory extends MazePrototypeFactory {

    protected EnchantedRoom roomProto;
    protected DoorNeedingSpell doorProto;
    
    public EnchantedMazePrototypeFactory(){
        this.roomProto = new EnchantedRoom(0);
        this.doorProto = new DoorNeedingSpell(null, null);
    }
    
}
