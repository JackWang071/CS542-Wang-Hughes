/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a6;
import java.lang.Runnable;

/**
 *
 * @author Jack
 */
public class CIA_Agent implements Agent_IF, Runnable{
    private String myFootprint;
    private boolean is_working;
    private String current_task;
    
    public CIA_Agent(String footprint){
        myFootprint = footprint;
    }
    
    public void run(){
        
    }
    
    public void startTask(){
        is_working = true;
        System.out.println("Agent "+myFootprint+" has started Task "+current_task);
    }
    
    public void stopTask(){
        is_working = false;
        System.out.println("Agent "+myFootprint+" has finished Task "+current_task);
    }
    
    private void processing(){
        System.out.println("Agent "+myFootprint+" has is working on Task "+current_task);
    }
    
    public void setTaskID(String tid){
        current_task = tid;
    }
}
