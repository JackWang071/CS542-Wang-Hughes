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
abstract class Decision {
    
    private String type;
    private int hazard_lvl;
    private int priority;
    
    public Decision(String t, int hL, int p){
        this.type = t;
        this.hazard_lvl = hL;
        this.priority = p;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public void execute(CEO ceo){
    }
}