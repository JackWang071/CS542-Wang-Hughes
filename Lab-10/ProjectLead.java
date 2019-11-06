/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a10;
import java.util.List;

/**
 *
 * @author Jack
 */
public class ProjectLead extends Leader{
    
    public ProjectLead(String name){
        super(name);
    }
    
    public void seeDanger(Hazard h){
        List<Hazard_Report_IF> subordinates = getSubordinates();
        for(Hazard_Report_IF sub : subordinates){
            if(sub != null && sub instanceof RegularEmployee){
                RegularEmployee regemp = (RegularEmployee) sub;
                regemp.fixIt();
            }
        }
        
        System.out.println("Project Leader " + getName() + " reported the hazard to their manager.");
        getDirectOverseer().seeDanger(h);
    }
    
}
