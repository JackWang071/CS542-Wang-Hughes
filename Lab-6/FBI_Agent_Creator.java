
package cs542_a6;

/**
 *
 * @author Jack and Duran
 */
public class FBI_Agent_Creator implements ObjectCreation_IF {
    private char[] footprints = {'A', 'B', 'C', 'D', 'E', 'F'};
    private int index;
    
    public FBI_Agent_Creator(){
        index = 0;
    }
    
    public Object create(){
        String this_footprint = "" + footprints[index];
        index += 1;
        FBI_Agent new_agent = new FBI_Agent(this_footprint);
        Thread t = new Thread(new_agent, "Agent "+this_footprint);
        t.start();
        return new_agent;
    }
}
