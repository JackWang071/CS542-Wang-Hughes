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
public class MoveServer implements LoadableServer_IF {
    private GameManager_IF env;
    private static MoveServer singleton;
    private static Unit actor;
    
    private MoveServer(){}
    
    public static MoveServer getServer(Unit actor){
        if(singleton == null){
            singleton = new MoveServer();
        }
        MoveServer.actor = actor;
        return singleton;
    }
    public void start(){
        env.getGUI().clearBoard();
        env.getGUI().highlightAffectedTiles(actor, "Move");
        env.finishServer();
    }
    
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
