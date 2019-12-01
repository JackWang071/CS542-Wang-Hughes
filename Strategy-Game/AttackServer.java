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
    private static AttackServer singleton;
    private static Unit actor;
    
    private AttackServer(){}
    
    public static AttackServer getServer(Unit actor){
        if(singleton == null){
            singleton = new AttackServer();
        }
        AttackServer.actor = actor;
        return singleton;
    }
    
    public void start(){
        env.getGUI().clearBoard();
        if(actor!= null && actor.can_attack()){
            env.getGUI().highlightAffectedTiles(actor, "Attack");
        }
        env.finishServer();
    }
    
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
