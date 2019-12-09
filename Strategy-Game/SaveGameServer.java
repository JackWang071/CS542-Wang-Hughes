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
public class SaveGameServer implements LoadableServer_IF{
    
    private static SaveGameServer singleton;
    private GameManager_IF env;
    
    private SaveGameServer(){}
    
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