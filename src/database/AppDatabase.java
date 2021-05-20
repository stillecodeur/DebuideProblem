package database;

import beds.Bed;
import beds.BedFactory;
import equipments.Equipment;
import equipments.EquipmentFactory;
import exceptions.IcuRoomNotAvailableException;
import exceptions.InsufficientResourceException;
import exceptions.NormalRoomNotAvailableException;
import exceptions.OxygenRoomNotAvailableException;
import rooms.Room;
import rooms.RoomFactory;
import utils.ConstantUtils;

import java.lang.reflect.Array;

public class AppDatabase {

    private static AppDatabase INSTANCE = null;

        private int oxygenCylinders = 110;
    private int ventilators = 16;
    private int normalMasks = 200;
    private int nonBreatherMasks = 120;
    private int flatBeds = 80;
    private int reclinerBeds = 100;
    private int normalRooms = 50;
    private int oxygenRooms = 50;
    private int icuRooms = 20;

    public synchronized static AppDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppDatabase();
        }
        return INSTANCE;
    }


    private AppDatabase() {

    }


    public Equipment getOxygenCylinder() throws InsufficientResourceException {
        if (oxygenCylinders == 0) {
            throw new InsufficientResourceException("Oxygen cylinder is not available");
        } else {
            oxygenCylinders--;
        }
        return EquipmentFactory.getEquipment(ConstantUtils.OXYGEN_CYLINDER);
    }


    public Equipment getNormalMask() throws InsufficientResourceException {
        if (normalMasks == 0) {
            throw new InsufficientResourceException("Normal Mask is not available");
        } else {
            normalMasks--;
        }
        return EquipmentFactory.getEquipment(ConstantUtils.NORMAL_MASK);
    }

    public Equipment getNonRebreatherMask() throws InsufficientResourceException {
        if (nonBreatherMasks == 0) {
            throw new InsufficientResourceException("Non Rebreather Mask is not available");
        } else {
            nonBreatherMasks--;
        }
        return EquipmentFactory.getEquipment(ConstantUtils.NON_REBREATHER_MASK);
    }

    public Equipment getVentilator() throws InsufficientResourceException {
        if (ventilators == 0) {
            throw new InsufficientResourceException("Ventilator is not available");
        } else {
            ventilators--;
        }
        return EquipmentFactory.getEquipment(ConstantUtils.VENTILATOR);
    }

    public Bed getFlatBed() throws InsufficientResourceException {
        if (flatBeds == 0) {
            throw new InsufficientResourceException("Flat Bed is not available");
        } else {
            flatBeds--;
        }
        return BedFactory.getBed(ConstantUtils.FLAT_BED);
    }

    public Bed getReclinerBed() throws InsufficientResourceException {
        if (reclinerBeds == 0) {
            throw new InsufficientResourceException("Recliner Bed is not available");
        } else {
            reclinerBeds--;
        }
        return BedFactory.getBed(ConstantUtils.RECLINER_BED);
    }

    public Room getIcuRoom() throws IcuRoomNotAvailableException {
        if (icuRooms == 0) {
            throw new IcuRoomNotAvailableException();
        } else {
            icuRooms--;
        }
        try {
            return RoomFactory.getRoom(ConstantUtils.ICU_ROOM);
        } catch (InsufficientResourceException e) {
            throw new IcuRoomNotAvailableException();
        }

    }

    public Room getNormalRoom() throws NormalRoomNotAvailableException {
        if (normalRooms == 0) {
            throw new NormalRoomNotAvailableException();
        } else {
            normalRooms--;
        }
        try {
            return RoomFactory.getRoom(ConstantUtils.NORMAL_ROOM);
        } catch (InsufficientResourceException e) {
            throw new NormalRoomNotAvailableException();
        }

    }

    public Room getOxygenRoom() throws OxygenRoomNotAvailableException {
        if (oxygenRooms == 0) {
            throw new OxygenRoomNotAvailableException();
        } else {
            oxygenRooms--;
        }
        try {
            return RoomFactory.getRoom(ConstantUtils.OXYGEN_ROOM);
        } catch (InsufficientResourceException e) {
            throw new OxygenRoomNotAvailableException();
        }

    }

    public int[] getAvailableRooms() {
        return new int[]{normalRooms, oxygenRooms, icuRooms};
    }


}
