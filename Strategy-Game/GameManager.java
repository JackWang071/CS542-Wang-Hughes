/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.util.List;

/**
 *
 * @author Jack and Duran
 */
public class GameManager implements GameManager_IF {
    
    private GameBoard board;
    private List<Army> factions;
    private LoadableServer_IF server;
    
    public GameManager(GameBoard board){
        this.board = board;
    }
    public void run(){
        server.start();
    }
    public void setServer(LoadableServer_IF server){
        this.server = server;
        server.setEnvironment(this);
    }
    
    public void showLegalAttacks(Unit u){
        
    }
    public void showLegalMoves(Unit u){
        
    }
    public void doNothing(Unit u){
        
    }
    public void showUnits(Army army){
        
    }
    

}
