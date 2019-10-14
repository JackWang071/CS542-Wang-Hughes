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
public class TaskRequester implements Runnable{
    private ObjectPool server;
    
    public TaskRequester(ObjectPool p){
        server = p;
    }
    
    public void run(){
        
    }
    
}
