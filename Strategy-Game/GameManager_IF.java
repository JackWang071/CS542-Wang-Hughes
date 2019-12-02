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
    public Army getCurrentArmy();
    public void updateArmies();
    public boolean checkEndGame();
    public Army nextArmy();
    
    public void setArmyPoints(int seed_value);
    public void setupBuildings(int seed_value);
    
    public void loadServer(LoadableServer_IF server);
    public void finishServer();
    
}
