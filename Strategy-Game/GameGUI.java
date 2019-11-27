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
    private GameOptionPanel message_board;
    
    public GameGUI(){
        super("Jack and Alex Project");
        board = GameBoard.getGameBoard(8);
        message_board = GameOptionPanel.getGameOptionPanel();
        
        setSize(1200,800);
        setLayout(new BorderLayout());  
        add(board, BorderLayout.WEST);
        add(message_board, BorderLayout.EAST);
        
        setVisible(true);
    }
    
    
    
}
