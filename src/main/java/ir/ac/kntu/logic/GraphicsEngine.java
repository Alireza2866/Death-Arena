package ir.ac.kntu.logic;

import java.util.ArrayList;

public interface GraphicsEngine {

    public void startGame(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB);

    public void initialize(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB, Soldier currentASoldier,
                           Soldier currentBSoldier);

    public void visualizeFight(Soldier currentASoldier,Soldier currentBSoldier, boolean firstSoldierMissed,
                               boolean secondSoldierMissed);

    public void visualizeDeath(ArrayList<Soldier> deads);

    public boolean visualizeVictoryCondition(Director.VictoryState victoryState);
}
