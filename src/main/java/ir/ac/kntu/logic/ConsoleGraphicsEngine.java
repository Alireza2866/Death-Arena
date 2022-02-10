package ir.ac.kntu.logic;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleGraphicsEngine implements GraphicsEngine {

    //TODO: Implement Graphics Options
    public void startGame(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB) {
        System.out.println("\n\n--***GAME STARTED WITH " + groupA.size() + " SOLDIER IN EACH TEAM***--\n\n");
        System.out.println("-------------------------------------------------------------------\n" +
                "Side A:");
        for (Soldier soldier : groupA) {
            System.out.println("[Id@" + soldier.getId() + "\t|Hp@" + soldier.getHealth() + "\t|Dmg@" +
                    soldier.getGun().getDamage() + "\t|Acc@" + soldier.getGun().getAccuracy() + "\t|Gun@" +
                    soldier.getGun() + "\t|Caliber@" + soldier.getGun().getCaliber() + "]");
        }
        System.out.println("\n\nSide B:");
        for (Soldier soldier : groupB) {
            System.out.println("[Id@" + soldier.getId() + "\t|Hp@" + soldier.getHealth() + "\t|Dmg@" +
                    soldier.getGun().getDamage() +  "\t|Acc@" + soldier.getGun().getAccuracy() + "\t|Gun@" +
                    soldier.getGun() + "\t|Caliber@" + soldier.getGun().getCaliber() + "]");
        }
        System.out.println("Enter something to continue\n");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    @Override
    public void initialize(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB, Soldier currentASoldier,
                           Soldier currentBSoldier) {
        System.out.println("-------------------------------------------------------------------\n" +
                "Side A:");
        for (Soldier soldier : groupA) {
            System.out.println("[Id@" + soldier.getId() + "\t|Hp@" + soldier.getHealth() + "\t|Dmg@" +
                    soldier.getGun().getDamage() + "\t|Acc@" + soldier.getGun().getAccuracy() + "\t|Gun@" +
                    soldier.getGun() + "\t|Caliber@" + soldier.getGun().getCaliber() + "]");
        }
        System.out.println("\n\nSide B:");
        for (Soldier soldier : groupB) {
            System.out.println("[Id@" + soldier.getId() + "\t|Hp@" + soldier.getHealth() + "\t|Dmg@" +
                    soldier.getGun().getDamage() +  "\t|Acc@" + soldier.getGun().getAccuracy() + "\t|Gun@" +
                    soldier.getGun() + "\t|Caliber@" + soldier.getGun().getCaliber() + "]");
        }
        System.out.println("-------------------------------------------------------------------\n" +
                "$$ARENA$$\n");
        System.out.println("Soldier:" + currentASoldier.getTeam() + "\n[Id@" + currentASoldier.getId() + "\t|Hp@" +
                currentASoldier.getHealth() + "\t|Dmg@" + currentASoldier.getGun().getDamage() +  "\t|Acc@" +
                currentASoldier.getGun().getAccuracy()  + "\t|Gun@" + currentASoldier.getGun() + "\t|Caliber@" +
                currentASoldier.getGun().getCaliber() + "]");
        System.out.println("Soldier:" + currentBSoldier.getTeam() + "\n[Id@" + currentBSoldier.getId() + "\t|Hp@" +
                currentBSoldier.getHealth() + "\t|Dmg@" + currentBSoldier.getGun().getDamage() + "\t|Acc@" +
                currentBSoldier.getGun().getAccuracy()  + "\t|Gun@" + currentBSoldier.getGun() + "\t|Caliber@" +
                currentBSoldier.getGun().getCaliber() + "]\n");
    }

    @Override
    public void visualizeFight(Soldier firstSoldier, Soldier secondSoldier, boolean firstSoldierHits,
                               boolean secondSoldierHits) {
        if (firstSoldierHits) {
        System.out.println("Soldier" + firstSoldier.getTeam() + " attacks @ Attack hits @ Soldier" +
                secondSoldier.getTeam() + " takes " + firstSoldier.getGun().getDamage() + " Dmg");
        } else {
            System.out.println("Soldier" + firstSoldier.getTeam() + " attacks @ Attack missed");
        }
        if (secondSoldier.getHealth() <= 0) {
            System.out.println("#Soldier" + secondSoldier.getTeam() + " died#");
            return;
        }
        if (secondSoldierHits) {
            System.out.println("Soldier" + secondSoldier.getTeam() + " attacks @ Attack hits @ Soldier" +
                    firstSoldier.getTeam() + " takes " + secondSoldier.getGun().getDamage() + " Dmg");
        } else {
            System.out.println("soldier" + secondSoldier.getTeam() + " attacks @ Attack missed");
        }
        if(firstSoldier.getHealth() <= 0) {
            System.out.println("#Soldier" + firstSoldier.getTeam() + " died#");
        }
    }

    @Override
    public void visualizeDeath(ArrayList<Soldier> deads) {
        System.out.println("-------------------------------------------------------------------\n");
        for (Soldier soldier : deads) {
            System.out.println("[Soldier" + soldier.getTeam() + " #DEAD# \t|Id@" + soldier.getId() + "\t|Dmg@" +
                    soldier.getGun().getDamage() + "\t|Acc@" + soldier.getGun().getAccuracy() + "\t|Gun@" +
                    soldier.getGun() + "\t|Caliber@" + soldier.getGun().getCaliber() + "]");
        }
    }

    @Override
    public boolean visualizeVictoryCondition(Director.VictoryState victoryState) {
        switch (victoryState) {
            case WIN_A:
                System.out.println("\n**Team A wins!**\n");
                return true;
            case WIN_B:
                System.out.println("\n**Team B wins!**\n");
                return true;
            default:
                System.out.println("Enter something to continue\n");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                return false;
        }
    }
}
