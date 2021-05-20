package decorators;

import beds.Bed;
import beds.FlatBed;
import rooms.Room;
import utils.ConstantUtils;

import java.util.List;

public class BedDecorator extends RoomDecorator {
    private final Room room;
    private List<Bed> beds;

    public BedDecorator(Room room, List<Bed> beds) {
        this.room = room;
        this.beds = beds;
    }

    @Override
    public String getDesc() {
        return room.getDesc() + beds.size() + " " + beds.get(0).getTitle();
    }
}
