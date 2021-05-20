package decorators;

import beds.Bed;
import equipments.Equipment;
import rooms.Room;

import java.util.List;

public class EquipmentDecorator extends RoomDecorator {

    private final Room room;
    private List<Equipment> equipments;

    public EquipmentDecorator(Room room, List<Equipment> equipments) {
        this.room = room;
        this.equipments = equipments;
    }

    @Override
    public String getDesc() {
        return room.getDesc() + equipments.size() + " " + equipments.get(0).getTitle();
    }
}
