package cs542_project;

/**
 *
 * @author Jack
 */
public class InitialSetupServer implements LoadableServer_IF{
    
    //variables
    private static int board_size;
    private static int num_players;
    private static InitialSetupServer singleton;
    private GameManager_IF env;
    
    //constructor
    private InitialSetupServer(){}
    
    //only allow for one initial setup server
    public static InitialSetupServer getServer(int size, int players){
        if(singleton == null){
            singleton = new InitialSetupServer();
        }
        board_size = size;
        num_players = players;
        return singleton;
    }
    
    //start initial setup server
    public void start(){
        
        env.setArmyPoints(board_size);
        env.createArmies(num_players);
        env.getGUI().showBoard(board_size);
        env.setupBuildings(board_size);
        env.getGUI().showArmySetup();
        
        env.finishServer();
    }
    
    //set environment to initial setup server
    public void setEnvironment(GameManager_IF env){
        this.env = env;
    }
}
