package cs542_project;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jack and Duran
 */
public interface GameManager_IF {
    public GameGUI getGUI();
    
    public void createArmies(int num_players);
    //public void addUnit(String type);
    public List<Army> getArmies();
    public void highlightRadius(int[] center, int radius);
    public void highlightLegalStartingPositions();
    
    public Army cycleThroughArmies(int repeats);
    
    public void showLegalAttacks(Unit u);
    public void showLegalMoves(Unit u);
    public void showUnits(Army army);
    
}
