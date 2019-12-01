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
public class AttackServer implements LoadableServer_IF {
    private GameManager_IF env;
    
    public void start(){
        
        env.getGUI().getBoard();
        
        env.finishServer();
    }
    
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
