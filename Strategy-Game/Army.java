package cs542_project;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 *
 * @author Jack and Duran
 */
public class Army {
    
    //variables
    private Race race;
    private int unit_cost_points;
    private List<Unit> units;
    private String name;
    private Color army_color;
    
    private static int ARMY_COUNT = 0;
    private static Color[] available_army_colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN};
    
    //constructor
    public Army(int unit_cost_points){
        this.unit_cost_points = unit_cost_points;
        units = new ArrayList();
        
        army_color = available_army_colors[ARMY_COUNT];
        ARMY_COUNT += 1;
        name = "Army " + ARMY_COUNT;
    }
    
    //helper functions
    public Color getArmyColor(){
        return army_color;
    }
    public String getName(){
        return name;
    }
    public Race getRace(){
        return race;
    }    
    public void setRace(Race race){
        this.race = race;
    }
    public int getPointsLeft(){
        return unit_cost_points;
    }

    //returns number of active units on board
    public int getNumActiveUnits(){
        int still_alive = units.size();
        for(Unit u : units){
            if(u.is_destroyed()){
                still_alive -= 1;
            }
        }
        return still_alive;
    }
    
    //creates unit factory
    public Unit_Factory createUnitFactory(){
        return new Unit_Factory(this);
    }
    
    //adds unit and updates remaining points
    public void addUnit(Unit u){
        if(u != null){
            units.add(u);
            unit_cost_points -= u.getCost();
        }
    }
    
    //updates status of all units
    public void updateUnitStatuses(){
        for(int i = 0; i < units.size(); i++){
            units.get(i).updateStatus();
        }
    }
}
