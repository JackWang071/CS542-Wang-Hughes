/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a10;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Jack and Duran
 */
public abstract class Admin extends Employee {
    private List<Hazard_Report_IF> subordinates;
    
    public Admin(String name){
        super(name);
        subordinates = new ArrayList();
    }
    
    public void addSubordinate(Hazard_Report_IF h){
        subordinates.add(h);
        h.setDirectOverseer(this);
    }
    
    public List<Hazard_Report_IF> getSubordinates(){
        return subordinates;
    }
    
    public void evacuate(){
        /*
        for(Hazard_Report_IF h : subordinates){
            h.evacuate();
        }
        */
        System.out.println(getName() + " is evacuating.");
    }
}
