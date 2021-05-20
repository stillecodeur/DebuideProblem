package rooms;

import beds.Bed;
import database.AppDatabase;
import decorators.*;
import equipments.Equipment;
import exceptions.IcuRoomNotAvailableException;
import exceptions.InsufficientResourceException;
import exceptions.NormalRoomNotAvailableException;
import exceptions.OxygenRoomNotAvailableException;
import utils.ConstantUtils;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory {
    public static Room getRoom(String type) throws InsufficientResourceException {
        Room room = null;
        switch (type) {
            case ConstantUtils
                    .NORMAL_ROOM:
                //Requires: 1 flat bed + 2 normal masks.
                room = new NormalRoom();
                List<Bed> beds = new ArrayList<>();

                beds.add(AppDatabase.getInstance().getFlatBed());

                room = new BedDecorator(room, beds);
                room = new PlusDecorator(room);

                List<Equipment> normalMasks = new ArrayList<>();
                while (normalMasks.size() != 2) {
                    normalMasks.add(AppDatabase.getInstance().getNormalMask());
                }
                room = new EquipmentDecorator(room, normalMasks);
                room = new ReservedDecorator(room);
                break;
            case ConstantUtils
                    .OXYGEN_ROOM:
                //Requires: 2 oxygen cylinders + 1 recliner bed + 2 non rebreather masks
                room = new OxygenRoom();

                List<Equipment> orOxCylinders = new ArrayList<>();
                while (orOxCylinders.size() != 2) {
                    orOxCylinders.add(AppDatabase.getInstance().getOxygenCylinder());
                }
                room = new EquipmentDecorator(room, orOxCylinders);
                room = new PlusDecorator(room);

                List<Bed> orBeds = new ArrayList<>();
                orBeds.add(AppDatabase.getInstance().getReclinerBed());
                room = new BedDecorator(room, orBeds);
                room = new PlusDecorator(room);

                List<Equipment> orNonReMasks = new ArrayList<>();
                while (orNonReMasks.size() != 2) {
                    orNonReMasks.add(AppDatabase.getInstance().getNonRebreatherMask());
                }
                room = new EquipmentDecorator(room, orNonReMasks);
                room = new ReservedDecorator(room);

                break;
            case ConstantUtils
                    .ICU_ROOM:
                //Requires: 1 ventilator + 1 recliner bed + 1 oxygen
                room = new IcuRoom();

                List<Equipment> icuVens = new ArrayList<>();
                icuVens.add(AppDatabase.getInstance().getVentilator());
                room = new EquipmentDecorator(room, icuVens);
                room = new PlusDecorator(room);

                List<Bed> icuBeds = new ArrayList<>();
                icuBeds.add(AppDatabase.getInstance().getReclinerBed());
                room = new BedDecorator(room, icuBeds);
                room = new PlusDecorator(room);

                List<Equipment> icuOxy = new ArrayList<>();
                icuOxy.add(AppDatabase.getInstance().getOxygenCylinder());
                room = new EquipmentDecorator(room, icuOxy);
                room = new ReservedDecorator(room);
                break;

        }
        return room;
    }
}
