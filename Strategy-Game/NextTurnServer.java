/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

/**
 *
 * @author Jack
 */
public class NextTurnServer implements LoadableServer_IF{
    private GameManager_IF env;
    private static NextTurnServer singleton;
    
    private NextTurnServer(){}
    
    public static NextTurnServer getServer(){
        if(singleton == null){
            singleton = new NextTurnServer();
        }
        return singleton;
    }
    
    public void start(){
        //Updates game board
        //updates game option board
        //updates all units in the current army
        
        env.updateArmies();
        if(env.checkEndGame() == true){
            env.finishServer();
            return;
        }
        env.nextArmy();
        env.getGUI().clearBoard();
        env.getGUI().clearOptionsPanel();
        env.getCurrentArmy().updateUnitStatuses();
        env.finishServer();
    }
    
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
