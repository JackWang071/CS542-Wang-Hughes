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
        implementDecision(decisions);
    }
    
    public void implementDecision(List<Decision> ls){
        if(ls.size() >= 2){
            int firstpriority = 0;
            int secondpriority = 0;
            
            for(int i = 1; i < ls.size(); i++){
                if(ls.get(i).getPriority() > ls.get(firstpriority).getPriority()){
                    firstpriority = i;
                }
            }
            for(int i = 1; i < ls.size(); i++){
                if(i != firstpriority && ls.get(i).getPriority() >= ls.get(secondpriority).getPriority()){
                    secondpriority = i;
                }
            }
            
            System.out.println(getName() + " decides to do this first: " + ls.get(firstpriority).getType());
            ls.get(firstpriority).execute(this);
            System.out.println(getName() + " decides to do this second: " + ls.get(firstpriority).getType());
            if(ls.get(secondpriority) instanceof Evacuation && ls.get(firstpriority) instanceof Evacuation){
                System.out.println("The building has already been evacuated.");
            }
            else if(ls.get(secondpriority) instanceof FileReport && ls.get(firstpriority) instanceof FileReport){
                System.out.println("A report has already been filed.");
            }
            else{
                ls.get(secondpriority).execute(this);
            }
        }
        else if(ls.size() == 1){
            ls.get(0).execute(this);
        }
    }
}
