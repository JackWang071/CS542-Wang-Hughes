/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jack and Duran
 */
public class GameManager implements GameManager_IF {
    
    private GameGUI gui;
    private List<Army> armies;
    private List<Building> buildings;
    private LoadableServer_IF server;
    
    private int current_turn;
    private Army current_army;
    private int army_points;
    
    public GameManager(){
        gui = new GameGUI(this);
        armies = new ArrayList();
        buildings = new ArrayList();
        current_turn = -1;
        army_points = 0;
        gui.showStartPanel();
    }
    
    public void run(){
        server.start();
    }
    
    public GameGUI getGUI(){
        return gui;
    }
    
    public void setServer(LoadableServer_IF server){
        this.server = server;
        server.setEnvironment(this);
        run();
    }
    
    public Army getCurrentArmy(){
        if(current_army == null){
            current_army = armies.get(current_turn);
        }
        return current_army;
    }
    
    public void createArmies(int num_players){
        for(int i = 0; i < num_players; i++){
            System.out.println();
            armies.add(new Army(army_points));
        }
    }
    
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
    
    public boolean checkEndGame(){
        if(armies.size() <= 1){
            gui.declareVictory();
            return true;
        }
        return false;
    }
    
    public Army nextArmy(){
        if(current_turn >= armies.size()-1){
            current_turn = -1;
        }
        current_turn += 1;
        current_army = armies.get(current_turn);
        return current_army;
    }
    
    public void setArmyPoints(int seed_value){
        army_points = seed_value * 5;
    }
    
    public void setupBuildings(int seed_value){
        BuildingFactory bfac = new BuildingFactory();
        for(int i = 0; i < seed_value/2; i++){
            buildings.add(bfac.getRandomBuilding());
        }
        gui.setupBuildings(buildings);
    }
    
    public void loadServer(LoadableServer_IF server){
        this.server = server;
        server.setEnvironment(this);
        run();
    }
    
    public void finishServer(){
        server.setEnvironment(null);
        server = null;
    }
    
    public void saveData(SaveData save){
        save.saveCurrentTurn(current_turn);
        save.saveArmies(armies);
        save.saveBuildings(buildings);
        gui.saveData(save);
    }
    
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
