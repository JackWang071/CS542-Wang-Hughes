/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
/**
 *
 * @author Jack
 */
public class GameOptionPanel extends JPanel {
    
    private GameGUI the_gui;
    
    public GameOptionPanel(GameGUI the_gui){
        this.the_gui = the_gui;
        
        this.setPreferredSize(new Dimension(400, 700));
        
        JButton tester = new JButton("Testing");
        tester.setPreferredSize(new Dimension(100, 50));
        this.add(tester);
    }
    

    
    
}
