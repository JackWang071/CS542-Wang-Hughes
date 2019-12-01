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
    
    private ListIterator army_iterator;
    private Army current_army;
    
    public GameManager(){
        gui = new GameGUI(this);
        factions = new ArrayList();
        
        
        
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
    
    public void createArmies(int num_players){
        for(int i = 0; i < num_players; i++){
            factions.add(new Army(40));
        }
    }
    
    public Army cycleThroughArmies(int repeats){
        if(army_iterator == null){
            army_iterator = factions.listIterator();
        }
        if(army_iterator.hasNext()){
            current_army = (Army) army_iterator.next();
        }
        else if (repeats != 1){
            army_iterator = factions.listIterator();
            current_army = (Army) army_iterator.next();
        }
        else{
            current_army = null;
            army_iterator = null;
        }
        return current_army;
    }
    
    public void showUnits(Army army){
        
    }
    
    public void finishServer(){
        server = null;
        server.setEnvironment(null);
    }
}
