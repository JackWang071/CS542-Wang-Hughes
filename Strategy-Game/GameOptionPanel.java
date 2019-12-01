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
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Jack
 */
public class GameOptionPanel extends JPanel {
    private GameGUI the_gui;
    private JPanel options_menu;

    private AttackOptionListener attack_option_listener;
    private MoveOptionListener move_option_listener;
    
    private TextArea current_unit_info;
    private TextField current_army_name;
    
    public GameOptionPanel(GameGUI the_gui){
        this.the_gui = the_gui;
        this.setPreferredSize(new Dimension(400, 700));
        
        attack_option_listener = new AttackOptionListener();
        move_option_listener = new MoveOptionListener();
        
        JButton attack_option = new JButton("Attack");
        JButton move_option = new JButton("Move");
        JButton end_turn = new JButton("End Turn");
        attack_option.addActionListener(attack_option_listener);
        move_option.addActionListener(move_option_listener);
        end_turn.addActionListener(new EndTurnListener());
        attack_option.setPreferredSize(new Dimension(100, 50));
        move_option.setPreferredSize(new Dimension(100, 50));
        end_turn.setPreferredSize(new Dimension(100, 50));
        
        options_menu.add(attack_option);
        options_menu.add(move_option);
        options_menu.add(end_turn);
        options_menu.setPreferredSize(new Dimension(400, 200));
        
        current_army_name = new TextField();
        current_unit_info = new TextArea();
    }
    
    public void startActualGame(){
        add(current_army_name);
        add(options_menu);
        add(current_unit_info);
        
        nextTurn();
    }
    
    private void nextTurn(){
        Army current_army = the_gui.getManager().cycleThroughArmies(0);
        current_army_name.setText("Turn: " + current_army.getName());
        
    }
    
    public void setCurrentUnit(Unit actor){
        attack_option_listener.setCurrentUnit(actor);
        move_option_listener.setCurrentUnit(actor);
        
        
    }
    
    private class AttackOptionListener implements ActionListener{
        private Unit actor;
        public void setCurrentUnit(Unit actor){
            this.actor = actor;
        }
        public void actionPerformed(ActionEvent e){
            //Tells GameManager to run the AttackServer?
        }
    }    
    
    private class MoveOptionListener implements ActionListener{
        private Unit actor;
        public void setCurrentUnit(Unit actor){
            this.actor = actor;
        }
        public void actionPerformed(ActionEvent e){
            //Tells GameManager to run the MoveServer?
        }
    }
    
    private class EndTurnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            nextTurn();
        }
    }
    
}
