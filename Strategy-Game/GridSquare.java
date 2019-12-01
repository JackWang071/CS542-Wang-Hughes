/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.lang.Math;
/**
 *
 * @author Jack and Duran
 */
public class GridSquare extends JButton{
    
    private int[] position;
    private Unit occupier;
    private Building building;
    private MoveHereListener move_here;
    private AttackHereListener attack_here;
    
    public GridSquare(int[] position){
        this.position = position;
        move_here = new MoveHereListener();
        attack_here = new AttackHereListener();
        addActionListener(move_here);
        addActionListener(attack_here);
    }
    
    public int[] getCoordinates(){
        return position;
    }
    public ObjectIcon getObjectIcon(){
        return ObjectIcon.getEmptyIcon();
    }
    
    public void redrawIcons(){
        String combined_icon = getObjectIcon().drawThis();
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
            setBackground(Color.CYAN);
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
            }
        }
        else{
            attack_here.setActor(null);
            redrawIcons();
        }
    }
    
    /**
     * TODO: allow the actor's previous position to redraw itself minus the actor
     */
    private class MoveHereListener implements ActionListener{
        private Unit actor;
        public void setActor(Unit actor){
            this.actor = actor;
        }
        public void actionPerformed(ActionEvent e){
            if(actor != null){
                actor.move(GridSquare.this);
                setActor(null);
            }
        }
    }
    
    private class AttackHereListener implements ActionListener{
        private Unit actor;
        public void setActor(Unit actor){
            this.actor = actor;
        }
        public void actionPerformed(ActionEvent e){
            if(actor != null){
                actor.attack(getOccupier(), getBuilding().getDefenseBoost());
                if(getOccupier().is_destroyed()){
                    setOccupier(null);
                    setActor(null);
                }
            }
        }
    }
}
