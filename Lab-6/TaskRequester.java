/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a6;
import java.lang.Runnable;
import java.util.Random;

/**
 *
 * @author Jack
 */
public class TaskRequester implements Runnable{
    private ObjectPool server;
    private int requester_id;
    private Random rando;

    public TaskRequester(ObjectPool p, int r){
        server = p;
        requester_id = r;
        rando = new Random();
    }

    public void run() {
        try {
            for(int i = 1; i < 4; i++){
                Agent_IF agent = (Agent_IF)server.waitForObject();
                if(agent == null){
                    throw new NullPointerException("Agent is null");
                }
                agent.startTask("" + requester_id + "-" + i);
                agent.run();
                Thread.sleep(rando.nextInt(2000));
                agent.stopTask();
                server.release(agent);
                Thread.sleep(200);
            }
        }
        catch(InterruptedException intex){
            System.out.println("Agent interrupted");
        }
        catch(NullPointerException npe){
            System.out.println(npe.getMessage());
        }
        System.out.println("Requester " + requester_id + " is done.");
    }

}
