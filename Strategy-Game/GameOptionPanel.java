/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Jack
 */
public class GameOptionPanel extends JPanel {
    
    private GameGUI the_gui;
    private JButton attack_option;
    private JButton move_option;
    private JButton end_turn;
    
    private TextField current_army_name;
    private Army current_army;
    
    public GameOptionPanel(GameGUI the_gui){
        this.the_gui = the_gui;
        this.setPreferredSize(new Dimension(400, 700));
        
        attack_option = new JButton("Attack");
        move_option = new JButton("Move");
        end_turn = new JButton("End Turn");
        
        attack_option.setPreferredSize(new Dimension(100, 50));
        move_option.setPreferredSize(new Dimension(100, 50));
        end_turn.setPreferredSize(new Dimension(100, 50));
        
        current_army_name = new TextField();
    }
    
    public void startActualGame(){
        
        end_turn.addActionListener(new EndTurnListener());
        
        add(current_army_name);
        add(attack_option);
        add(move_option);
        add(end_turn);
        
        
        nextTurn();
    }
    
    public void nextTurn(){
        current_army = the_gui.getManager().cycleThroughArmies(0);
        current_army_name.setText("Turn: " + current_army.getName());
        
    }
    
    
    public class AttackOptionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            
        }
    }    
    
    public class MoveOptionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    public class EndTurnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            nextTurn();
        }
    }
    
}
