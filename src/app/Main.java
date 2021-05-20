package app;

import database.AppDatabase;
import exceptions.IcuRoomNotAvailableException;
import exceptions.InsufficientResourceException;
import exceptions.NormalRoomNotAvailableException;
import exceptions.OxygenRoomNotAvailableException;
import rooms.Room;
import utils.ConstantUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int[] availableRooms = new int[0];
        do {
            System.out.println("Please enter the type of room you want to reserve");
            String input = scanner.nextLine();
            if (input.equals("exit")) break;
            try {
                Room room = reserveRoom(input);
                System.out.println(room.getDesc());
                availableRooms = AppDatabase.getInstance().getAvailableRooms();
                System.out.println("Remaining availability: \n" +
                        "Normal Rooms:" + availableRooms[0] + "\n" +
                        "Oxygen Rooms:" + availableRooms[1] + "\n" +
                        "ICU:" + availableRooms[2]);
            } catch (OxygenRoomNotAvailableException e) {
                System.out.println("Sorry, no rooms could be reserved. : \n" +
                        "Normal Rooms:" + availableRooms[0] + " (depending upon resources allocated)\n" +
                        "Oxygen Rooms:" + "N/A" + "\n" +
                        "ICU:" + availableRooms[2]+" (depending upon resources allocated)");
            } catch (IcuRoomNotAvailableException e) {
                System.out.println("Sorry, no rooms could be reserved. : \n" +
                        "Normal Rooms:" + availableRooms[0] + " (depending upon resources allocated)\n" +
                        "Oxygen Rooms:" + availableRooms[1] + " (depending upon resources allocated)\n" +
                        "ICU:" + "N/A");
            } catch (NormalRoomNotAvailableException e) {
                System.out.println("Sorry, no rooms could be reserved. : \n" +
                        "Normal Rooms:" + "N/A" + "\n" +
                        "Oxygen Rooms:" + availableRooms[1] + " (depending upon resources allocated)\n" +
                        "ICU:" + availableRooms[2]+" (depending upon resources allocated)");
            }
        } while (true);
    }

    public static Room reserveRoom(String type) throws IcuRoomNotAvailableException, NormalRoomNotAvailableException, OxygenRoomNotAvailableException {
        if (type.equals(ConstantUtils.ICU_ROOM)) {
            return AppDatabase.getInstance().getIcuRoom();
        } else if (type.equals(ConstantUtils.NORMAL_ROOM)) {
            return AppDatabase.getInstance().getNormalRoom();
        } else if (type.equals(ConstantUtils.OXYGEN_ROOM)) {
            return AppDatabase.getInstance().getOxygenRoom();
        }
        return null;
    }
}
