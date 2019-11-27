/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Jack
 */
public class Cs542_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example");  
        
        f.setSize(800,800);
        f.setLayout(new BorderLayout());  
        f.add(GameBoard.getGameBoard(5), BorderLayout.WEST);
        f.add(new JPanel(), BorderLayout.EAST);
        
        
        f.setVisible(true);
    }
    
}
