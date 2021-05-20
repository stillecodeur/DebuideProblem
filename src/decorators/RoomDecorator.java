package decorators;

import rooms.Room;

public abstract class RoomDecorator implements Room {

    @Override
    public String getDesc() {
        return "";
    }
}
