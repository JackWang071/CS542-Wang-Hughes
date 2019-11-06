/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a10;
/**
 *
 * @author Jack and Duran
 */
public abstract class Leader extends Admin{
    
    public Leader(String name){
        super(name);
    }
    
    public boolean getFeedback(Hazard h){
        if(h.getHazard_lvl() >= 3){
            return true;
        }
        return false;
    }
    
}
