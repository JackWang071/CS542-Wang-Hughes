/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Jack and Duran
 */
public class GameManager implements GameManager_IF {
    
    private GameGUI gui;
    private List<Army> factions;
    private List<Building> buildings;
    private LoadableServer_IF server;
    
    private int iterator_index;
    private Army current_army;
    private int army_points;
    
    public GameManager(){
        gui = new GameGUI(this);
        factions = new ArrayList();
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
            factions.add(new Army(army_points));
        }
    }
    
    public Army nextArmy(){
        if(iterator_index >= factions.size()){
            iterator_index = 0;
        }
        do{
            current_army = factions.get(iterator_index);
            iterator_index += 1;
        } while(current_army.getNumActiveUnits() <= 0);
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
}
