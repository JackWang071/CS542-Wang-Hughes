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
public class Army {
    
    private Race race;
    private int unit_cost_points;
    private List<Unit> units;
    
    public Army(Race race){
        this.race = race;
        unit_cost_points = 0;
        units = new ArrayList();
    }
    
    public Race getRace(){
        return race;
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
        units.add(u);
    }
    
    public void gameMessage(){
        
    }
}
