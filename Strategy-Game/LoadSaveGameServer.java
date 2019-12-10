package cs542_project;

/**
 *
 * @author Jack
 */
public class LoadSaveGameServer implements LoadableServer_IF {
    
    //variables
    private static LoadSaveGameServer singleton;
    private GameManager_IF env;
    
    //constructor
    private LoadSaveGameServer(){}
    
    //only allow for one loadsave game server
    public static LoadSaveGameServer getServer(){
        if(singleton == null){
            singleton = new LoadSaveGameServer();
        }
        return singleton;
    }
    
    //set environment to loadsave game server environment
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
    
    //start loadsave game server
    public void start(){
        SaveData save = new SaveData();
        save.loadFromFile();
        env.loadSaveData(save);
        env.finishServer();
    }
}
