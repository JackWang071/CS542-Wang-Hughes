package cs542_project;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jack and Duran
 */
public class GameManager implements GameManager_IF {
    
    //variables
    private GameGUI gui;
    private List<Army> armies;
    private List<Building> buildings;
    private LoadableServer_IF server;
    
    private int current_turn;
    private Army current_army;
    private int army_points;
    
    //constructor
    public GameManager(){
        gui = new GameGUI(this);
        armies = new ArrayList();
        buildings = new ArrayList();
        current_turn = -1;
        army_points = 0;
        gui.showStartPanel();
    }
    
    //start server
    public void run(){
        server.start();
    }
    
    //gets GUI
    public GameGUI getGUI(){
        return gui;
    }
    
    //sets server to inputted environment and runs it
    public void setServer(LoadableServer_IF server){
        this.server = server;
        server.setEnvironment(this);
        run();
    }
    
    //gets current army
    public Army getCurrentArmy(){
        if(current_army == null){
            current_army = armies.get(current_turn);
        }
        return current_army;
    }
    
    //creates correct number of armies based off number of players
    public void createArmies(int num_players){
        for(int i = 0; i < num_players; i++){
            System.out.println();
            armies.add(new Army(army_points));
        }
    }
    
    //remove destroyed army 
    public void removeDestroyedArmies(){
        int counter = 0;
        while(counter < armies.size()){
            if(armies.get(counter).getNumActiveUnits() <= 0){
                armies.remove(counter);
            }
            else{
                counter += 1;
            }
        }
    }
    
    //checks if game is over yet
    public boolean checkEndGame(){
        if(armies.size() <= 1){
            gui.declareVictory();
            return true;
        }
        return false;
    }
    
    //returns army of player who's turn  it is next
    public Army nextArmy(){
        if(current_turn >= armies.size()-1){
            current_turn = -1;
        }
        current_turn += 1;
        current_army = armies.get(current_turn);
        return current_army;
    }
    
    //sets number of points for army
    public void setArmyPoints(int seed_value){
        army_points = seed_value * 5;
    }
    
    //sets up buildings
    public void setupBuildings(int seed_value){
        BuildingFactory bfac = new BuildingFactory();
        for(int i = 0; i < seed_value/2; i++){
            buildings.add(bfac.getRandomBuilding());
        }
        gui.setupBuildings(buildings);
    }
    
    //sets and loads inputted server
    public void loadServer(LoadableServer_IF server){
        this.server = server;
        server.setEnvironment(this);
        run();
    }
    
    //sets it so no server is active
    public void finishServer(){
        server.setEnvironment(null);
        server = null;
    }
    
    //saves game state
    public void saveData(SaveData save){
        save.saveCurrentTurn(current_turn);
        save.saveArmies(armies);
        save.saveBuildings(buildings);
        gui.saveData(save);
    }
    
    //loads game state
    public void loadSaveData(SaveData save){
        //Set the current turn.
        current_turn = save.getCurrentTurn();
        //Set the available points for each army. Not entirely necessary.
        setArmyPoints(save.getBoardSize());
        //Recreate the armies.
        createArmies(save.getNumArmies());
        //Set the recreated armies' races.
        save.getArmyRaces(armies);
        //Load in unit information from the save file. This also populates each army with their units.
        save.loadUnits(armies);
        //Load in building information from the save file.
        save.loadBuildings();
        //Set the building 
        buildings = save.getBuildings();
        //Update the GUI and game board with the save file information.
        //This will allow each unit and building to be placed at the locations where they were at the time of the save.
        gui.loadSaveData(save);
        //Update the units' HP and action statuses.
        save.loadUnitStatuses();
        //Remove any armies with no active units.
        removeDestroyedArmies();
    }
}
