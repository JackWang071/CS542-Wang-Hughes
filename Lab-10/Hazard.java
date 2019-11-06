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
public class Hazard {
    
    private String type;
    private int hazard_lvl;
    
    public Hazard(String t, int hL){
        type = t;
        hazard_lvl = hL;
    }
    
    public int getHazard_lvl(){
        return hazard_lvl;
    }
    
    public String getType(){
        return type;
    }
}