/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a6;

/**
 *
 * @author Jack
 */
public class FBI_Agent_Creator {
    private char[] footprints = {'@', '#', '$', '*', '.', '?'};
    private int index;
    
    public FBI_Agent_Creator(){
        index = 0;
    }
    
    public Object create(){
        String this_footprint = "" + footprints[index];
        index += 1;
        FBI_Agent new_agent = new FBI_Agent(this_footprint);
        
        return new_agent;
    }
}
