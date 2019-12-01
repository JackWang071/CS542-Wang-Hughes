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

    public List<Army> getArmies();
    public Army getCurrentArmy();
    public Army nextArmy();
    
    public void showUnits(Army army);
    
    public void loadServer(String server);
    public void finishServer();
    
}
