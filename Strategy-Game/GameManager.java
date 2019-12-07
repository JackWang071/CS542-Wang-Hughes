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
    
    private int iterator_index;
    private Army current_army;
    private int army_points;
    
    public GameManager(){
        gui = new GameGUI(this);
        armies = new ArrayList();
        buildings = new ArrayList();
        iterator_index = 0;
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
        return current_army;
    }
    
    public void createArmies(int num_players){
        for(int i = 0; i < num_players; i++){
            System.out.println();
            armies.add(new Army(army_points));
        }
    }
    
    public void updateArmies(){
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
        if(iterator_index >= armies.size()){
            iterator_index = 0;
        }
        current_army = armies.get(iterator_index);
        iterator_index += 1;
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
    
    public void loadSaveFile(){
        
    }
    
    public void outputSaveFile(){
        
    }
}
