/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;
/**
 *
 * @author Jack and Duran
 */
public class GameGUI extends JFrame {
    
    private GameBoard board;
    private GameOptionPanel game_options_panel;
    private GameStartPanel start_panel;
    private ArmySetupPanel army_setup_panel;
    private GameManager_IF game_manager;
    
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
    
    public void showStartPanel(){
        add(start_panel, BorderLayout.CENTER);
        start_panel.chooseStartingOptions();
        
        setVisible(true);
    }
    
    public void showBoard(int size){
        board.createBoard(size);
        remove(start_panel);
        add(board, BorderLayout.WEST);
        revalidate();
        repaint();
    }
    
    public void showArmySetup(){
        add(army_setup_panel, BorderLayout.EAST);
        army_setup_panel.startArmySetup();
        revalidate();
        repaint();
    }
    
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
    
    public void highlightAffectedTiles(Unit actor, String purpose){
        board.highlightAffectedTiles(actor, purpose);
    }
    
    public void highlightStartingPositions(Army army){
        board.highlightStartingPositions(army);
    }
    
    public void clearOptionsPanel(){
        game_options_panel.clearOptionsPanel();
    }
    
    public void clearBoard(){
        board.clearBoard();
    }
    
    public void updateGUI_selectedTile(GridSquare g){
        clearOptionsPanel();
        game_options_panel.currentTileDetails(g);
    }
    
    public void setupBuildings(List<Building> buildings){
        board.addBuildings(buildings);
    }
    
    public GameManager_IF getManager(){
        return game_manager;
    }
}
