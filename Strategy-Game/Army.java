/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 *
 * @author Jack and Duran
 */
public class Army {
    
    private Race race;
    private int unit_cost_points;
    private List<Unit> units;
    private String name;
    private Color army_color;
    
    private static int ARMY_COUNT = 0;
    private static Color[] available_army_colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN};
    
    public Army(int unit_cost_points){
        this.unit_cost_points = unit_cost_points;
        units = new ArrayList();
        
        army_color = available_army_colors[ARMY_COUNT];
        ARMY_COUNT += 1;
        name = "Army " + ARMY_COUNT;
    }
    
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

    public int getNumActiveUnits(){
        int still_alive = units.size();
        for(Unit u : units){
            if(u.is_destroyed()){
                still_alive -= 1;
            }
        }
        return still_alive;
    }
    
    public Unit_Factory createUnitFactory(){
        return new Unit_Factory(this);
    }
    
    public void addUnit(Unit u){
        if(u != null){
            units.add(u);
            unit_cost_points -= u.getCost();
        }
    }
    
    public void updateUnitStatuses(){
        for(int i = 0; i < units.size(); i++){
            units.get(i).updateStatus();
        }
    }
}
