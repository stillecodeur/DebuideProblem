package decorators;

import beds.Bed;
import rooms.Room;

import java.util.List;

public class PlusDecorator extends RoomDecorator{
    private final Room room;

    public PlusDecorator(Room room) {
        this.room = room;
    }

    @Override
    public String getDesc() {
        return room.getDesc() +" + ";
    }

}
