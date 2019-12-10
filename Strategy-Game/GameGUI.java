package cs542_project;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.List;
/**
 *
 * @author Jack and Duran
 */
public class GameGUI extends JFrame {
    
    //variables
    private GameBoard board;
    private GameOptionPanel game_options_panel;
    private GameStartPanel start_panel;
    private ArmySetupPanel army_setup_panel;
    private GameManager_IF game_manager;
    
    //constructor
    public GameGUI(GameManager_IF game_manager){
        super("Jack and Alex Project");
        this.game_manager = game_manager;
        setSize(1200,800);
        setLayout(new BorderLayout());
        
        board = new GameBoard(this);
        army_setup_panel = new ArmySetupPanel(this);
        start_panel = new GameStartPanel(this);
        game_options_panel = new GameOptionPanel(this);
    }
    
    //display start panel
    public void showStartPanel(){
        add(start_panel, BorderLayout.CENTER);
        start_panel.chooseStartingOptions();
        
        setVisible(true);
    }
    
    //displays game board
    public void showBoard(int size){
        board.createBoard(size);
        remove(start_panel);
        add(board, BorderLayout.WEST);
        revalidate();
        repaint();
    }
    
    //readys army setup panel
    public void showArmySetup(){
        add(army_setup_panel, BorderLayout.EAST);
        army_setup_panel.startArmySetup();
        revalidate();
        repaint();
    }
    
    //readys board for game to start
    public void showReadyGame(){
        remove(army_setup_panel);
        add(game_options_panel, BorderLayout.EAST);
        game_options_panel.startActualGame();
        revalidate();
        repaint();
        
        clearOptionsPanel();
        clearBoard();
        board.activateBoard();
        game_manager.getCurrentArmy().updateUnitStatuses();
    }
    
    //shows starting, moving, or attacking titles
    public void highlightAffectedTiles(Unit actor, String purpose){
        board.highlightAffectedTiles(actor, purpose);
    }
    
    //show army spawn locations
    public void highlightStartingPositions(Army army){
        board.highlightStartingPositions(army);
    }
    
    //clears option panel
    public void clearOptionsPanel(){
        game_options_panel.clearOptionsPanel();
    }
    
    //clears board
    public void clearBoard(){
        board.clearBoard();
    }
    
    //shows updates GUI to display current title details
    public void updateGUI_selectedTile(GridSquare g){
        clearOptionsPanel();
        game_options_panel.currentTileDetails(g);
    }
    
    //adds buildings to board
    public void setupBuildings(List<Building> buildings){
        board.addBuildings(buildings);
    }
    
    //gets game manager
    public GameManager_IF getManager(){
        return game_manager;
    }
    
    //declare winner and print appropriate message
    public void declareVictory(){
        remove(board);
        remove(game_options_panel);
        String victor = game_manager.getCurrentArmy().getName();
        JLabel endgame_message = new JLabel("Victory! The winner is " + victor + ".", SwingConstants.CENTER);
        add(endgame_message);
        revalidate();
        repaint();
    }
    
    //save game
    public void saveData(SaveData save){
        board.saveBoardDetails(save);
    }
    
    //load game
    public void loadSaveData(SaveData save){
        showBoard(save.getBoardSize());
        board.loadBoardDetails(save);
        showReadyGame();
    }
}
