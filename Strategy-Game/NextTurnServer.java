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
    
    public void start(){
        //Updates game board
        //updates game option board
        //updates all units in the current army
    }
    
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
