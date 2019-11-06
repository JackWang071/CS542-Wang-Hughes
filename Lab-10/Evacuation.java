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
    
    public Evacuation(int p){
        super(p);
    }
    
    public void execute(CEO ceo){
        ceo.evacuate();
    } 
}
