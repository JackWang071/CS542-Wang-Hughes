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
public class LoadSaveGameServer implements LoadableServer_IF {
    private static LoadSaveGameServer singleton;
    private GameManager_IF env;
    
    private LoadSaveGameServer(){}
    
    public static LoadSaveGameServer getServer(){
        if(singleton == null){
            singleton = new LoadSaveGameServer();
        }
        return singleton;
    }
    
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
    
    public void start(){
        SaveData save = new SaveData();
        save.loadFromFile();
        env.loadSaveData(save);
        env.finishServer();
    }
}
