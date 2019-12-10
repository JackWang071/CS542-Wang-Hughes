package cs542_project;

/**
 *
 * @author Jack
 */
public class SaveGameServer implements LoadableServer_IF{
    //variables
    private static SaveGameServer singleton;
    private GameManager_IF env;
    
    private SaveGameServer(){}
    
    //only allow for one saveGameServer
    public static SaveGameServer getServer(){
        if(singleton == null){
            singleton = new SaveGameServer();
        }
        return singleton;
    }
    
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
    
    public void start(){
        SaveData save = new SaveData();
        env.saveData(save);
        save.outputToFile();
        env.finishServer();
    }
}
