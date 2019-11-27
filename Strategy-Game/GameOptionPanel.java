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
    
    private static GameOptionPanel game_option_panel;
    
    private GameOptionPanel(){
        this.setPreferredSize(new Dimension(400, 700));
        this.setLayout(new BorderLayout());  
        
        
        JButton tester = new JButton("Testing");
        tester.setSize(50, 50);
        this.add(tester, BorderLayout.NORTH);
    }
    
    public static GameOptionPanel getGameOptionPanel(){
        if(game_option_panel == null){
            game_option_panel = new GameOptionPanel();
        }
        return game_option_panel;
    }
}
