package cs542_a6;

/**
 *
 * @author Duran and Jack
 */
public interface ObjectPool_IF {
    
    public int getSize();
    
    public int getCapacity();
    
    public void setCapacity(int c);
    
    public Object getObject();
    
    public Object waitForObject() throws InterruptedException;
    
    public void release(Object o);
}