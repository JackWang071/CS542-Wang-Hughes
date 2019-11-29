/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jack
 */
public class GameGUI extends JFrame {
    
    private GameBoard board;
    private GameOptionPanel game_options_panel;
    private GameStartPanel start_panel;
    private GameManager game_manager;
    
    public GameGUI(){
        super("Jack and Alex Project");
        setSize(1200,800);
        setLayout(new BorderLayout());
        
        start_panel = new GameStartPanel(this);
        add(start_panel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public void boardSetup(int size){
        board = new GameBoard(size);
        game_options_panel = new GameOptionPanel();
        
        start_panel.setVisible(false);
        add(board, BorderLayout.WEST);
        add(game_options_panel, BorderLayout.EAST);
        revalidate();
    }
    
    public GameBoard getBoard(){
        return board;
    }
    
    public GameOptionPanel getOptionPanel(){
        return game_options_panel;
    }
    
}
