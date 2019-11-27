/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jack
 */
public class GameGUI extends JFrame {
    
    private GameBoard board;
    private JPanel message_board;
    
    public GameGUI(){
        board = GameBoard.getGameBoard(8);
    }
    
    
    
}
