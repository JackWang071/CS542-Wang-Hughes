/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Math;

/**
 *
 * @author Jack and Duran
 */
public class GridSquare extends JButton implements GameObject_IF{
    
    private int[] position;
    private Unit occupier;
    private Building building;
    private MoveHereListener move_here;
    private AttackHereListener attack_here;
    
    public GridSquare(int[] position){
        this.position = position;
        move_here = new MoveHereListener();
        attack_here = new AttackHereListener();
    }
    
    public int[] getPosition(){
        return position;
    }
    public ObjectIcon getObjectIcon(){
        return ObjectIcon.getEmptyIcon();
    }
    public int[] setStartingPosition(int[] startPos){
        return getPosition();
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
    }
    public void setBuilding(Building build){
        building = building;
    }
    
    public void removeOccupier(){
        occupier = null;
    }
    
    public void setMoveHereListener(Unit actor){
        if(actor == null){
            move_here.setActor(null);
            redrawIcons();
        }
        int actor_moveDist = actor.getMoveDist();
        int[] actor_pos = actor.getPosition();
        int distance = Math.abs(actor_pos[0] - position[0]) + Math.abs(actor_pos[1] - position[1]);
        if(getOccupier() == null && distance <= actor_moveDist){
            move_here.setActor(actor);
            setBackground(actor.getArmy().getArmyColor());
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
        }
        int actor_range = actor.getRange();
        int[] actor_pos = actor.getPosition();
        int distance = Math.abs(actor_pos[0] - position[0]) + Math.abs(actor_pos[1] - position[1]);
        if(getOccupier() != null && distance <= actor_range){
            attack_here.setActor(actor);
            setBackground(actor.getArmy().getArmyColor());
        }
        else{
            attack_here.setActor(null);
            redrawIcons();
        }
    }
    
    private class MoveHereListener implements ActionListener{
        private Unit actor;
        public void setActor(Unit actor){
            this.actor = actor;
        }
        public void actionPerformed(ActionEvent e){
            if(actor != null){
                actor.move(getPosition());
                setOccupier(actor);
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
            }
        }
    }
}
