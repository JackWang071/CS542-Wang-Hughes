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
public class Evacuation extends Decision {
    
    private String type;
    private int hazard_lvl;
    private int priority;
    
    public Evacuation(String t, int hL, int p){
        super(t, hL, p);
    }
    
    public void execute(CEO ceo){
        System.out.println("CEO " + ceo.getName() + " has a report filed with the city's environmental department.");
    } 
}
