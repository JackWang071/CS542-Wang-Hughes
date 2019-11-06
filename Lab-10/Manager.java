/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a10;
import java.util.List;

/**
 *
 * @author Jack and Duran
 */
public class Manager extends Admin{
    
    public Manager(String name){
        super(name);
    }
    
    public void seeDanger(Hazard h){
        List<Hazard_Report_IF> subordinates = getSubordinates();
        for(Hazard_Report_IF sub : subordinates){
            if(sub != null && sub instanceof Leader){
                Leader supervisor = (Leader) sub;
                if(!supervisor.getFeedback(h)){
                    System.out.println("Manager " + getName() + " did not report the hazard.");
                    return;
                }
            }
        }
        
        System.out.println("Manager " + getName() + " reported the hazard to the CEO.");
        getDirectOverseer().seeDanger(h);
    }
    
    public Decision suggestDecision(Hazard h){
        
        if(h.getHazard_lvl() >= 4){
            System.out.println("Manager " + getName() + " suggests evacuation.");
            return new Evacuation(5);
        }
        else{
            System.out.println("Manager " + getName() + " suggests filing a report.");
            return new FileReport(3);
        }
    }
}
