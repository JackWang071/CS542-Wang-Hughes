/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JButton;

/**
 *
 * @author Jack and Duran
 */
public class GridSquare extends JButton implements GameObject_IF{
    
    private int[] position;
    private Unit occupier;
    private Building building;
    
    public GridSquare(int[] position){
        this.position = position;
    }
    
    public int[] getPosition(){
        return position;
    }
    public ObjectIcon getObjectIcon(){
        return null;
    }
    public int[] setStartingPosition(int[] startPos){
        return getPosition();
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
}
