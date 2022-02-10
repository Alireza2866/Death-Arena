package ir.ac.kntu.logic;

import ir.ac.kntu.logic.gun.Gun;

import java.util.Objects;

public class Soldier {
    private int id;

    private int health;

    private Gun gun;

    private String team;

    public Soldier(int id, int health, Gun gun, String team){
        this.id = id;
        this.health = health;
        this.gun = gun;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Gun getGun() {
        return gun;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;}
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Soldier soldier = (Soldier) object;
        return getId() == soldier.getId() && getHealth() == soldier.getHealth() && Objects.equals(getGun(), soldier.getGun());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHealth(), getGun());
    }
}
