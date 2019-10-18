
package cs542_a6;
import java.lang.Runnable;

/**
 *
 * @author Jack and Duran
 */
public class CIA_Agent implements Agent_IF, Runnable{
    private String myFootprint;
    private boolean is_working;
    private String current_task;
    
    public CIA_Agent(String footprint){
        myFootprint = footprint;
    }
    
    public void run(){
        processing();
    }
    
    public void startTask(){
        is_working = true;
        System.out.println("CIA Agent "+myFootprint+" has started Task "+current_task);
    }
    
    public void stopTask(){
        is_working = false;
        System.out.println("CIA Agent "+myFootprint+" has finished Task "+current_task);
    }
    
    private void processing(){
        System.out.println("CIA Agent "+myFootprint+" is working on Task "+current_task);
    }
    
    public void setTaskID(String tid){
        current_task = tid;
    }
}
