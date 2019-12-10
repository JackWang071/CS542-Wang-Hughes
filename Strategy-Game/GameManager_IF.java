package cs542_project;

import java.util.List;

/**
 *
 * @author Jack and Duran
 */

//interface for GameManager
public interface GameManager_IF {
    public GameGUI getGUI();
    
    public void createArmies(int num_players);
    public Army getCurrentArmy();
    public void removeDestroyedArmies();
    public boolean checkEndGame();
    public Army nextArmy();
    
    public void setArmyPoints(int seed_value);
    public void setupBuildings(int seed_value);
    
    public void loadServer(LoadableServer_IF server);
    public void finishServer();
    
    public void saveData(SaveData save);
    public void loadSaveData(SaveData save);
}
