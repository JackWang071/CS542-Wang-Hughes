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
    private static Color[] available_army_colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
    
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

    public List<Unit> getUnits(){
        return units;
    }
    
    public Unit_Factory createUnitFactory(){
        return new Unit_Factory(this);
    }
    
    public void addUnit(Unit u){
        if(u.getCost() <= unit_cost_points){
            units.add(u);
            unit_cost_points -= u.getCost();
        }
    }
    
    public void gameMessage(){
        
    }
}
