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
public abstract class Decision {
    
    private int priority;
    
    public Decision(int p){
        this.priority = p;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public abstract void execute(CEO ceo);
}