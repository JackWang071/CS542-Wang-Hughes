package cs542_a10;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jack and Duran
 */
public class Evacuation extends Decision {
    
    private List<Hazard_Report_IF> sub;
    private List<Hazard_Report_IF> subM;
    private List<Hazard_Report_IF> subL;
    
    public Evacuation(int p){
        super(p);
    }
    
    public void execute(CEO ceo){
        sub = ceo.getSubordinates();
        int i;
        
        //evac reg employees and sort the others into groups
        for(i = 0; i < sub.size(); i++) {
            if( sub.get(i) instanceof Manager){
                subM.add(sub.get(i));
            }
            if( sub.get(i) instanceof Leader){
                subL.add(sub.get(i));
            }
            if( sub.get(i) instanceof RegularEmployee){
                sub.get(i).evacuate();
            }
        }
        //evacutate leaders (supervisors/projectLeads)
        for(i = 0; i < subL.size(); i++) {
            subL.get(i).evacuate();
        }
        
        //evacutate managers
        for(i = 0; i < subM.size(); i++) {
            subM.get(i).evacuate();
        }       
        
        //evactuate CEO
        ceo.evacuate();
    } 
    
}
