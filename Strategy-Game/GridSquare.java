/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 *
 * @author Jack and Duran
 */
public class GridSquare extends JButton{
    
    private int[] position;
    private Unit occupier;
    private Building building;
    private GameBoard the_board;
    private MoveHereListener move_here;
    private AttackHereListener attack_here;
    private TileSelectListener select_here;
    
    private JLabel unit_icon_wrapper;
    private JLabel building_icon_wrapper;
    
    public GridSquare(int[] position, GameBoard the_board){
        this.position = position;
        this.the_board = the_board;
        move_here = new MoveHereListener();
        attack_here = new AttackHereListener();
        select_here = new TileSelectListener();
        
        unit_icon_wrapper = new JLabel();
        building_icon_wrapper = new JLabel();
        add(unit_icon_wrapper);
        add(building_icon_wrapper);
    }
    
    public int[] getCoordinates(){
        return position;
    }
    
    public void activateListeners(){
        addActionListener(move_here);
        addActionListener(attack_here);
        addActionListener(select_here);
    }
    
    public void redrawIcons2(){
        building_icon_wrapper.setIcon(null);
        unit_icon_wrapper.setIcon(null);
        if(building != null){
            building_icon_wrapper.setIcon(building.getObjectIcon().returnIcon());
        }
        if(occupier != null){
            unit_icon_wrapper.setIcon(occupier.getObjectIcon().returnIcon());
            setBackground(occupier.getArmy().getArmyColor());
        }
        else{
            setBackground(null);
        }
    }
    
    public void redrawIcons(){
        String combined_icon = "";
        if(building != null){
            combined_icon += building.getObjectIcon().drawThis();
        }
        if(occupier != null){
            combined_icon += occupier.getObjectIcon().drawThis();
            setBackground(occupier.getArmy().getArmyColor());
        }
        else{
            setBackground(null);
        }
        setText(combined_icon);
    }
    
    public Unit getOccupier(){
        return occupier;
    }
    public Building getBuilding(){
        return building;
    }
    
    public void setOccupier(Unit occ){
        occupier = occ;
        redrawIcons();
    }
    public void setBuilding(Building build){
        building = build;
        redrawIcons();
    }
    
    public void setMoveHereListener(Unit actor){
        if(actor == null){
            move_here.setActor(null);
            redrawIcons();
            return;
        }
        
        int actor_moveDist = actor.getMoveDist();
        int[] actor_pos = actor.getPosition().getCoordinates();
        int distance = Math.abs(actor_pos[0] - position[0]) + Math.abs(actor_pos[1] - position[1]);
        if(getOccupier() == null && distance > 0 && distance <= actor_moveDist){
            move_here.setActor(actor);
            setBackground(Color.BLUE);
        }
        else{
            move_here.setActor(null);
            redrawIcons();
        }
    }
    
    public void setAttackHereListener(Unit actor){
        if(actor == null){
            attack_here.setActor(null);
            redrawIcons();
            return;
        }
        int actor_range = actor.getRange();
        int[] actor_pos = actor.getPosition().getCoordinates();
        int distance = Math.abs(actor_pos[0] - position[0]) + Math.abs(actor_pos[1] - position[1]);
        if(distance > 0 && distance <= actor_range){
            setBackground(Color.MAGENTA);
            if(getOccupier() != null){
                attack_here.setActor(actor);
                if(getOccupier().getArmy().equals(actor.getArmy())){
                    setBackground(getOccupier().getArmy().getArmyColor());
                }
            }
        }
        else{
            attack_here.setActor(null);
            redrawIcons();
        }
    }
    
    private void updateTileStatus(){
        the_board.clearBoard();
        the_board.getGUI().updateGUI_selectedTile(this);
    }
    
    /**
     * TODO: allow the actor's previous position to redraw itself minus the actor
     */
    private class MoveHereListener implements ActionListener{
        private Unit actor;
        public void setActor(Unit actor){
            this.actor = actor;
        }
        public boolean hasActor(){
            return (actor != null);
        }
        public void actionPerformed(ActionEvent e){
            if(actor != null){
                actor.move(GridSquare.this);
                setActor(null);
                updateTileStatus();
            }
        }
    }
    
    private class AttackHereListener implements ActionListener{
        private Unit actor;
        public void setActor(Unit actor){
            this.actor = actor;
        }
        public boolean hasActor(){
            return (actor != null);
        }
        public void actionPerformed(ActionEvent e){
            if(actor != null){
                actor.attack(getOccupier());
                setActor(null);
                if(getOccupier().is_destroyed()){
                    setOccupier(null);
                }
                updateTileStatus();
            }
        }
    }
    
    private class TileSelectListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(!attack_here.hasActor() && !move_here.hasActor()){
                updateTileStatus();
            }
        }
    }
}
