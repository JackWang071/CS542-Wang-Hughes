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
public class CIA_Agent_Creator implements ObjectCreation_IF {
    private char[] footprints = {'A', 'B', 'C', 'D', 'E', 'F'};
    private int index;
    
    public CIA_Agent_Creator(){
        index = 0;
    }
    
    public Object create(){
        String this_footprint = "" + footprints[index];
        index += 1;
        CIA_Agent new_agent = new CIA_Agent(this_footprint);
        Thread t = new Thread(new_agent, "Agent "+this_footprint);
        t.start();
        return new_agent;
    }
}
