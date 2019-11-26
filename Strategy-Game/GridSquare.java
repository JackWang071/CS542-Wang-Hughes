/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Jack and Duran
 */
public class GridSquare extends JButton implements GameObject_IF{
    
    private int[] position;
    private List<GameObject_IF> occupiers;
    
    public GridSquare(int[] position){
        this.position = position;
        occupiers = new ArrayList();
    }
    
    public List<GameObject_IF> getOccupiers(){
        return occupiers;
    }
    public int[] getPosition(){
        return position;
    }
    public ObjectIcon getObjectIcon(){
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
