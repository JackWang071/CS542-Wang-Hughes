package cs542_a6;

import java.util.ArrayList;

/**
 *
 * @author Duran and Jack
 */
//i believe ths should actually be public according to the textbook (pg 166)
public class ObjectPool implements ObjectPool_IF {
    
    private static ObjectPool poolInstance;
    private int size;
    private Object lockObject;
    private int maxInstances;
    
    private ObjectPool(ObjectCreation_IF c, int capacity, int max){
        size = capacity;
        maxInstances = max;
        poolInstance = null;
    }
    
    public synchronized static ObjectPool getPoolInstance(ObjectCreation_IF c, int capacity, int max){
        if(poolInstance == null){
            poolInstance = new ObjectPool(c, capacity, max);
        }
        return poolInstance;
    }
    
    public int getSize(){
        return size;
    }
    
    public int getCapacity(){
        return size;
    }
    
    public void setCapacity(int c){
        
    }
    
    public Object getObject(){
        
    }
    
    public Object waitForObject(){
        
    }
    
    public void release(Object o){
        
    }
}