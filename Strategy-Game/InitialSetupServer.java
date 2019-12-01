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
public class InitialSetupServer implements LoadableServer_IF{
    private static int board_size;
    private static int num_players;
    private static InitialSetupServer singleton;
    private GameManager_IF env;
    
    private InitialSetupServer(){}
    
    public static InitialSetupServer getServer(int size, int players){
        if(singleton == null){
            singleton = new InitialSetupServer();
        }
        board_size = size;
        num_players = players;
        return singleton;
    }
    public void start(){
        
        env.setArmyPoints(board_size);
        env.createArmies(num_players);
        env.getGUI().showBoard(board_size);
        env.setupBuildings(board_size);
        env.getGUI().showArmySetup();
        
        env.finishServer();
    }
    
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
