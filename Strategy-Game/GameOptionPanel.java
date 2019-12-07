/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Jack
 */
public class GameOptionPanel extends JPanel {
    private GameGUI the_gui;
    private JPanel options_menu;
    
    private JButton attack_option;
    private JButton move_option;
    private JButton end_turn;
    private JButton save_game;

    private AttackOptionListener attack_option_listener;
    private MoveOptionListener move_option_listener;
    
    private TextArea current_unit_info;
    private JLabel current_army_name;
    
    public GameOptionPanel(GameGUI the_gui){
        this.the_gui = the_gui;
        this.setPreferredSize(new Dimension(400, 700));
        
        attack_option_listener = new AttackOptionListener();
        move_option_listener = new MoveOptionListener();
        
        attack_option = new JButton("Attack");
        move_option = new JButton("Move");
        end_turn = new JButton("End Turn");
        attack_option.addActionListener(attack_option_listener);
        move_option.addActionListener(move_option_listener);
        end_turn.addActionListener(new EndTurnListener());
        attack_option.setPreferredSize(new Dimension(100, 50));
        move_option.setPreferredSize(new Dimension(100, 50));
        end_turn.setPreferredSize(new Dimension(100, 50));
        
        save_game = new JButton("Save");
        save_game.addActionListener(new SaveGameListener());
        save_game.setPreferredSize(new Dimension(100, 50));
        
        options_menu = new JPanel();
        options_menu.add(attack_option);
        options_menu.add(move_option);
        options_menu.add(end_turn);
        options_menu.setPreferredSize(new Dimension(400, 200));
        
        current_army_name = new JLabel();
        current_army_name.setOpaque(true);
        current_army_name.setPreferredSize(new Dimension(300, 40));
        current_army_name.setHorizontalAlignment(SwingConstants.CENTER);
        
        current_unit_info = new TextArea(20, 40);
    }
    
    public void startActualGame(){
        add(current_army_name);
        add(options_menu);
        add(save_game);
        add(current_unit_info);
        
        clearOptionsPanel();
    }
    
    public void clearOptionsPanel(){
        current_army_name.setText("Turn: " + the_gui.getManager().getCurrentArmy().getName());
        current_army_name.setBackground(the_gui.getManager().getCurrentArmy().getArmyColor());
        attack_option_listener.setCurrentUnit(null);
        move_option_listener.setCurrentUnit(null);
        current_unit_info.setText("");
    }
    
    public void currentTileDetails(GridSquare g){
        int[] g_pos = g.getCoordinates();
        String tile_info = "Coordinates: "+ g_pos[0] + "," + g_pos[1] + "\n\n";
        
        if(g.getOccupier() != null){
            tile_info += g.getOccupier().toString();
            if(g.getOccupier().getArmy().equals(the_gui.getManager().getCurrentArmy())){
                if(g.getOccupier().can_attack()){
                    attack_option_listener.setCurrentUnit(g.getOccupier());
                }
                if(g.getOccupier().can_move()){
                    move_option_listener.setCurrentUnit(g.getOccupier());
                }
            }
        }
        else{
            attack_option_listener.setCurrentUnit(null);
            move_option_listener.setCurrentUnit(null);
        }
        if(g.getBuilding() != null){
            tile_info += "\n" + g.getBuilding().toString();
        }
        
        current_unit_info.setText(tile_info);
    }
    
    private class AttackOptionListener implements ActionListener{
        private Unit actor;
        public void setCurrentUnit(Unit actor){
            if(actor == null){
                this.actor = null;
                attack_option.setVisible(false);
            }
            else{
                if(actor.can_attack()){
                    this.actor = actor;
                    attack_option.setVisible(true);
                }
            }
        }
        public void actionPerformed(ActionEvent e){
            //Tells GameManager to run the AttackServer?
            if(actor != null){
                the_gui.getManager().loadServer(AttackServer.getServer(actor));
            }
        }
    }    
    
    private class MoveOptionListener implements ActionListener{
        private Unit actor;
        public void setCurrentUnit(Unit actor){
            if(actor == null){
                this.actor = null;
                move_option.setVisible(false);
            }
            else{
                if(actor.can_move()){
                    this.actor = actor;
                    move_option.setVisible(true);
                }
            }
        }
        public void actionPerformed(ActionEvent e){
            //Tells GameManager to run the MoveServer?
            if(actor != null){
                the_gui.getManager().loadServer(MoveServer.getServer(actor));
            }
        }
    }
    
    private class SaveGameListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            the_gui.getManager().loadServer(SaveGameServer.getServer());
        }
    }
    
    private class EndTurnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            the_gui.getManager().loadServer(NextTurnServer.getServer());
        }
    }
    
}
