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
    private LoadableServer_IF server;
    
    private int iterator_index;
    private Army current_army;
    
    public GameManager(){
        gui = new GameGUI(this);
        factions = new ArrayList();
        this.iterator_index = 0;
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
    
    public List<Army> getArmies(){
        return factions;
    }
    public Army getCurrentArmy(){
        return current_army;
    }
    
    public void createArmies(int num_players){
        for(int i = 0; i < num_players; i++){
            factions.add(new Army(40));
        }
    }
    
    public Army nextArmy(){
        if(iterator_index == factions.size()){
            iterator_index = 0;
        }
        current_army = factions.get(iterator_index);
        iterator_index += 1;
        return current_army;
    }
    
    public void showUnits(Army army){
        
    }
    
    public void loadServer(String server){
        
    }
    
    public void finishServer(){
        server = null;
        server.setEnvironment(null);
    }
}
