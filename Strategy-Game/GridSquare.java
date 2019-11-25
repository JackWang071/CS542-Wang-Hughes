/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jack and Duran
 */
public class GridSquare implements GameObject_IF{
    
    private int[] position;
    private List<GameObject_IF> occupiers;
    
    public GridSquare(int[] position){
        this.position = position;
    }
    
    public List<GameObject_IF> getOccupiers(){
        return occupiers;
    }
    public int[] getPosition(){
        return position;
    }
    public ObjectIcon getIcon(){
        return null;
    }
    public int[] getStartingPosition(){
        return getPosition();
    }
    public String getName(){
        return "";
    }
    
    public void addOccupier(GameObject_IF occ){
        occupiers.add(occ);
    }
    
    public boolean removeOccupier(String name){
        for(int i = 0; i < occupiers.size(); i++){
            if(name.equalsIgnoreCase(occupiers.get(i).getName())){
                occupiers.remove(i);
                return true;
            }
        }
        return false;
    }
}
