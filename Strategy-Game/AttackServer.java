package cs542_project;

/**
 *
 * @author Jack
 */
public class AttackServer implements LoadableServer_IF {
    
    //variables
    private GameManager_IF env;
    private static AttackServer singleton;
    private static Unit actor;
    
    //constructor
    private AttackServer(){}
    
    //only allow for creation of single attack server
    public static AttackServer getServer(Unit actor){
        if(singleton == null){
            singleton = new AttackServer();
        }
        AttackServer.actor = actor;
        return singleton;
    }
    
    //start attack server
    public void start(){
        env.getGUI().clearBoard();
        if(actor!= null && actor.can_attack()){
            env.getGUI().highlightAffectedTiles(actor, "Attack");
        }
        env.finishServer();
    }
    
    //set environment
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
