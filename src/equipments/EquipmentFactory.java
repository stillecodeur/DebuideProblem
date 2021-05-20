package equipments;

import utils.ConstantUtils;

public class EquipmentFactory {

    public static Equipment getEquipment(String type) {
        switch (type) {
            case ConstantUtils
                    .OXYGEN_CYLINDER:
                return new OxygenCylinder();
            case ConstantUtils
                    .NORMAL_MASK:
                return new NormalMask();
            case ConstantUtils
                    .VENTILATOR:
                return new Ventilator();
            case ConstantUtils
                    .NON_REBREATHER_MASK:
                return new NonRebreatherMask();
        }
        return null;
    }
}
