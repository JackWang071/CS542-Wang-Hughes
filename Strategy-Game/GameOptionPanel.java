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
        
        options_menu = new JPanel();
        options_menu.add(attack_option);
        options_menu.add(move_option);
        options_menu.add(end_turn);
        options_menu.setPreferredSize(new Dimension(400, 200));
        
        current_army_name = new TextField();
        current_unit_info = new TextArea(20, 40);
    }
    
    public void startActualGame(){
        add(current_army_name);
        add(options_menu);
        add(current_unit_info);
        
        updateNextTurn();
    }
    
    public void updateNextTurn(){
        current_army_name.setText("Turn: " + the_gui.getManager().getCurrentArmy().getName());
        attack_option_listener.setCurrentUnit(null);
        move_option_listener.setCurrentUnit(null);
        current_unit_info.setText("");
    }
    
    public void currentTileDetails(GridSquare g){
        String tile_info = "";
        if(g.getOccupier() != null && g.getOccupier().getArmy().equals(the_gui.getManager().getCurrentArmy())){
            attack_option_listener.setCurrentUnit(g.getOccupier());
            move_option_listener.setCurrentUnit(g.getOccupier());
            tile_info += g.getOccupier().getName() + "\nHP:" + g.getOccupier().getHP();
        }
        if(g.getBuilding() != null){
            tile_info += "\n" + g.getBuilding().getName();
        }
        
        int[] g_pos = g.getCoordinates();
        
        current_unit_info.setText("Coordinates: "+ g_pos[0] + "," + g_pos[1]);
    }
    
    private class AttackOptionListener implements ActionListener{
        private Unit actor;
        public void setCurrentUnit(Unit actor){
            this.actor = actor;
        }
        public void actionPerformed(ActionEvent e){
            //Tells GameManager to run the AttackServer?
            the_gui.getManager().loadServer(AttackServer.getServer(actor));
        }
    }    
    
    private class MoveOptionListener implements ActionListener{
        private Unit actor;
        public void setCurrentUnit(Unit actor){
            this.actor = actor;
        }
        public void actionPerformed(ActionEvent e){
            //Tells GameManager to run the MoveServer?
            the_gui.getManager().loadServer(MoveServer.getServer(actor));
        }
    }
    
    private class EndTurnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            the_gui.getManager().loadServer(NextTurnServer.getServer());
        }
    }
    
}
