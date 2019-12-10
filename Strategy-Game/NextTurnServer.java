package cs542_project;

/**
 *
 * @author Jack and Alexander
 */
public class NextTurnServer implements LoadableServer_IF{
    
    //variables
    private GameManager_IF env;
    private static NextTurnServer singleton;
    
    //contstructor
    private NextTurnServer(){}
    
    //only allow for single next turn server
    public static NextTurnServer getServer(){
        if(singleton == null){
            singleton = new NextTurnServer();
        }
        return singleton;
    }
    
    //start next turn server
    public void start(){
        //Updates game board
        //updates game option board
        //updates all units in the current army
        
        env.removeDestroyedArmies();
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
    
    //set environment to next turn server environment
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
