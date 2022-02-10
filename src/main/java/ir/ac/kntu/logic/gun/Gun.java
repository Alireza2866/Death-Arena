package ir.ac.kntu.logic.gun;

import java.util.Objects;

public abstract class Gun {
    private int baseDamage;

    private int baseAccuracy;

    private Caliber caliber;

    public Gun(int baseDamage, int baseAccuracy, Caliber caliber) {
        this.baseDamage = baseDamage;
        this.baseAccuracy = baseAccuracy;
        this.caliber = caliber;
    }

    public int getDamage() {
        return baseDamage + caliber.getDamageChange();
    }

    public int getAccuracy() {
        return baseAccuracy + caliber.getAccuracyChange();
    }

    public Caliber getCaliber() {
        return caliber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Gun gun = (Gun) object;
        return baseDamage == gun.baseDamage && baseAccuracy == gun.baseAccuracy && getCaliber() == gun.getCaliber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseDamage, baseAccuracy, getCaliber());
    }
}
