package beds;

import utils.ConstantUtils;

public class BedFactory {
    public static Bed getBed(String type) {
        switch (type) {
            case ConstantUtils
                    .FLAT_BED:
                return new FlatBed();
            case ConstantUtils
                    .RECLINER_BED:
                return new ReclinerBed();
        }
        return null;
    }
}
