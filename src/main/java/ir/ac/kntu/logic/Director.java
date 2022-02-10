package ir.ac.kntu.logic;

import ir.ac.kntu.logic.gun.AssaultRifle;
import ir.ac.kntu.logic.gun.Caliber;
import ir.ac.kntu.logic.gun.Gun;
import ir.ac.kntu.logic.gun.SniperRifle;

import java.util.ArrayList;

public class Director {

    private ArrayList<Soldier> groupA;

    private ArrayList<Soldier> groupB;

    private ArrayList<Soldier> deads;

    private GraphicsEngine graphicsEngine;

    private Soldier currentASoldier;

    private Soldier currentBSoldier;

    private VictoryState victoryState;

    public Director(GraphicsEngine graphicsEngine) {
        //TODO: Intialize soldiers
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();
        deads = new ArrayList<>();
        int numberOfSoldiers = RandomHelper.nextInt(1,11);
        for (int i = 0; i < numberOfSoldiers ; i++) {
            groupA.add(generateARandomSoldier(i + 1, "A"));
            groupB.add(generateARandomSoldier(i + 1, "B"));
        }
        this.graphicsEngine = graphicsEngine;
        victoryState = VictoryState.NOT_FINISHED;
    }

    private Soldier generateARandomSoldier(int id, String team) {
        ArrayList<Caliber> calibers = new ArrayList<Caliber>();
        calibers.add(Caliber.FIVE);
        calibers.add(Caliber.TEN);
        Caliber selectedCaliber = calibers.get(RandomHelper.nextInt(calibers.size()));
        ArrayList<Gun> guns = new ArrayList<>();
        guns.add(new AssaultRifle(selectedCaliber));
        guns.add(new SniperRifle(selectedCaliber, true));
        guns.add(new SniperRifle(selectedCaliber, false));
        Gun selectedGun = guns.get(RandomHelper.nextInt(guns.size()));
        return new Soldier(id, RandomHelper.nextInt(10, 100), selectedGun, team);
    }

    public void startGameLoop() {
        //TODO: Add Game Logic Loop here - Graphics also go here
        graphicsEngine.startGame(groupA, groupB);
        while (true) {
            currentASoldier = selectARandomSoldier(groupA);
            groupA.remove(currentASoldier);
            currentBSoldier = selectARandomSoldier(groupB);
            groupB.remove(currentBSoldier);
            graphicsEngine.initialize(groupA, groupB, currentASoldier, currentBSoldier);
            fight();
            graphicsEngine.visualizeDeath(deads);
            if (groupA.size() == 0) {
                victoryState = VictoryState.WIN_B;
            } else if (groupB.size() == 0) {
                victoryState = VictoryState.WIN_A;
            }
            boolean endOfGame = graphicsEngine.visualizeVictoryCondition(victoryState);
            if (endOfGame) {
                break;
            }
        }
    }

    private void fight() {
        Soldier firstSoldier = currentASoldier;
        Soldier secondSoldier = currentBSoldier;
        if (RandomHelper.nextBoolean()) {
            firstSoldier = currentBSoldier;
            secondSoldier = currentASoldier;
        }
        boolean firstSoldierHits = rollADice(firstSoldier.getGun().getAccuracy());
        boolean secondSoldierHits = rollADice(secondSoldier.getGun().getAccuracy());
        if (firstSoldierHits) {
            secondSoldier.setHealth(secondSoldier.getHealth() - firstSoldier.getGun().getDamage());
        }
        if (secondSoldier.getHealth() > 0 && secondSoldierHits) {
            firstSoldier.setHealth(firstSoldier.getHealth() - secondSoldier.getGun().getDamage());
        }
        graphicsEngine.visualizeFight(firstSoldier, secondSoldier, firstSoldierHits, secondSoldierHits);
        //Setting group of first soldier
        if (firstSoldier.getHealth() > 0 && firstSoldier.getTeam().equals("A")) {
                groupA.add(firstSoldier);
        }
        if (firstSoldier.getHealth() > 0 && firstSoldier.getTeam().equals("B")) {
                groupB.add(firstSoldier);
        }
        if (firstSoldier.getHealth() <= 0) {
            deads.add(firstSoldier);
        }
        //Setting group of second soldier
        if (secondSoldier.getHealth() > 0 && secondSoldier.getTeam().equals("A")) {
            groupA.add(secondSoldier);
        }
        if (secondSoldier.getHealth() > 0 && secondSoldier.getTeam().equals("B")) {
            groupB.add(secondSoldier);
        }
        if (secondSoldier.getHealth() <= 0) {
            deads.add(secondSoldier);
        }
    }

    private boolean rollADice(int accuracy) {
        int randomNumber = RandomHelper.nextInt(1, 101);
        if(randomNumber <= accuracy) {
            return true;
        }
        return false;
    }

    private Soldier selectARandomSoldier(ArrayList<Soldier> soldiers) {
        int index = RandomHelper.nextInt(soldiers.size());
        return soldiers.get(index);
    }

    public enum VictoryState {WIN_A, WIN_B, NOT_FINISHED}
}
