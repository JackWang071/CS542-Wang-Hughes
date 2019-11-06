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
public class Evacuation extends Decision {
    
    public Evacuation(int p){
        super("Evacuation", p);
    }
    
    public void execute(CEO ceo){
        List<Hazard_Report_IF> ceo_subordinates = ceo.getSubordinates();
        List<Hazard_Report_IF> managers = new ArrayList();        
        List<Hazard_Report_IF> leaders = new ArrayList();
        
        System.out.println("REGULAR EMPLOYEES evacuate FIRST.");
        //Iterating over managers
        for(Hazard_Report_IF manager : ceo_subordinates){
            if(manager instanceof RegularEmployee){
                manager.evacuate();
            }
            else{
                Admin confirmed_manager = (Admin) manager;
                List<Hazard_Report_IF> manager_sub = confirmed_manager.getSubordinates();
                managers.add(manager);
                //Iterating over leaders
                for(Hazard_Report_IF leader : manager_sub){
                    if(leader instanceof RegularEmployee){
                        leader.evacuate();
                    }
                    else{
                        Admin confirmed_leader = (Admin) leader;
                        List<Hazard_Report_IF> leader_sub = confirmed_leader.getSubordinates();
                        leaders.add(leader);
                        //Iterating over Regular Employees?
                        for(Hazard_Report_IF employee : leader_sub){
                            employee.evacuate();
                        }
                    }
                }
            }
        }
        
        System.out.println("SUPERVISORS and PROJECT LEADS evacuate SECOND.");
        //evacutate leaders (supervisors/projectLeads)
        for(Hazard_Report_IF sub1 : leaders){
            sub1.evacuate();
        }
        System.out.println("MANAGERS evacuate THIRD.");
        //evacutate leaders (supervisors/projectLeads)
        for(Hazard_Report_IF sub1 : managers){
            sub1.evacuate();
        }
        //evactuate CEO
        System.out.println("The CEO evacuates LAST.");
        ceo.evacuate();
    } 
}
