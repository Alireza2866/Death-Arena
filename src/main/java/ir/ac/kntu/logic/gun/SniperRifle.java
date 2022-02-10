package ir.ac.kntu.logic.gun;

import ir.ac.kntu.logic.RandomHelper;

import java.util.Objects;

public class SniperRifle extends Gun{
    private boolean hasScope;

    private int scopeAccuracy;

    public SniperRifle(Caliber caliber, boolean hasScope) {
        super(20, 60, caliber);
        scopeAccuracy = RandomHelper.nextInt(5, 16);
        this.hasScope = hasScope;
    }

    public boolean setHasScope() {
        return hasScope;
    }

    public void getHasScope(boolean hasScope) {
        this.hasScope = hasScope;
    }

    @Override
    public int getAccuracy() {
        if(hasScope) {
            return super.getAccuracy() + scopeAccuracy;
        }
        return super.getAccuracy();
    }

    @Override
    public String toString() {
        if(hasScope) {
            return "SR-Scope";
        }
        return "SR";
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
        return hasScope == that.hasScope && getAccuracy() == that.getAccuracy() && getDamage() == that.getDamage() &&
                getCaliber() == that.getCaliber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasScope, getAccuracy(), getDamage(), getCaliber());
    }
}
