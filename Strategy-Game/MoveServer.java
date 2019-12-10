package cs542_project;

/**
 *
 * @author Jack and Alexander
 */
public class MoveServer implements LoadableServer_IF {
    
    //variables
    private GameManager_IF env;
    private static MoveServer singleton;
    private static Unit actor;
    
    //constructor
    private MoveServer(){}
    
    //only allow for one move server
    public static MoveServer getServer(Unit actor){
        if(singleton == null){
            singleton = new MoveServer();
        }
        MoveServer.actor = actor;
        return singleton;
    }
    
    //start move server
    public void start(){
        env.getGUI().clearBoard();
        if(actor!= null && actor.can_move()){
            env.getGUI().highlightAffectedTiles(actor, "Move");
        }
        env.finishServer();
    }
    
    //set environment to move server environment
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
