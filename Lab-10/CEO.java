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
 * @author Jack
 */
public class CEO extends Admin{
    
    public CEO(String name){
        super(name);
    }
    
    public void seeDanger(Hazard h){
        List<Hazard_Report_IF> subordinates = getSubordinates();
        List<Decision> decisions = new ArrayList();
        for(Hazard_Report_IF sub : subordinates){
            if(sub != null && sub instanceof Manager){
                Manager manager = (Manager) sub;
                decisions.add(manager.suggestDecision(h));
            }
        }
    }
    
    public void implementDecision(List<Decision> ls){
        
    }
    
}
