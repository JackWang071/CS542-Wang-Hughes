
package cs542_a6;
import java.lang.Runnable;
/**
 *
 * @author Jack and Duran
 */
public interface Agent_IF extends Runnable{
    void startTask();
    void stopTask();
    public void setTaskID(String tid);
}
