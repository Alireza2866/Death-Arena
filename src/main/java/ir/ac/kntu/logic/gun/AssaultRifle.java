package ir.ac.kntu.logic.gun;

import java.util.Objects;

public class AssaultRifle extends Gun{
    public AssaultRifle(Caliber caliber) {
        super(10 , 50, caliber);
    }

    @Override
    public String toString() {
        return "AR";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        SniperRifle that = (SniperRifle) object;
        return getAccuracy() == that.getAccuracy() && getDamage() == that.getDamage() &&
                getCaliber() == that.getCaliber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccuracy(), getDamage(), getCaliber());
    }
}
