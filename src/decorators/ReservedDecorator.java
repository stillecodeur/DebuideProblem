package decorators;

import rooms.Room;

public class ReservedDecorator extends RoomDecorator{

    private final Room room;

    public ReservedDecorator(Room room) {
        this.room = room;
    }

    @Override
    public String getDesc() {
        return room.getDesc() +") reserved";
    }

}
