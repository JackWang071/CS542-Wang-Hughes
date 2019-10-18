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
    private int task_id_gen;
    private int requester_id;
    private Random rando;

    public TaskRequester(ObjectPool p, int r){
        server = p;
        requester_id = r;
        task_id_gen = 0;
        rando = new Random();
    }

    public void run() {
        try {
            Agent_IF agent = (Agent_IF)server.waitForObject();
            task_id_gen++;
            agent.setTaskID("" + requester_id + "-" + task_id_gen);
            agent.startTask();
            agent.run();
            Thread.sleep(rando.nextInt(2000));
            agent.stopTask();
            server.release(agent);
        }
        catch(InterruptedException intex){
            System.out.println("Agent interrupted");
        }
        catch(NullPointerException npe){
            System.out.println("Null pointer exception thrown");
        }
    }

}
