package ir.ac.kntu.logic.gun;

public enum Caliber {
    FIVE(0, 15), TEN(10, -10);

    private int damageChange;

    private int accuracyChange;

    private Caliber(int damageChange, int accuracyChange) {
        this.damageChange = damageChange;
        this.accuracyChange = accuracyChange;
    }

    public int getDamageChange() {
        return damageChange;
    }

    public int getAccuracyChange() {
        return accuracyChange;
    }

    @Override
    public String toString() {
        switch (this) {
            case FIVE:
                return "5mm";
            case TEN:
                return "10mm";
            default:
                return "";
        }
    }
}
