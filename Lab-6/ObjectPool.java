package cs542_a6;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 *
 * @author Duran and Jack
 */
//i believe ths should actually be public according to the textbook (pg 166)
public class ObjectPool implements ObjectPool_IF {
    
    private static ObjectPool poolInstance;
    private int size;  //Number of free objects
    private int instanceCount;  //number of objects already created
    private int maxInstances;  //Maximum number of objects available
    
    //textbook stuff
    private Object[] pool;
    private Object lockObject = new Object();
    ObjectCreation_IF creator;
    
    private ObjectPool(ObjectCreation_IF c, int max) {
        creator = c;
        size = max;
        instanceCount = 0;
        maxInstances = max;
        pool = new Object[max];
    }
    
    public synchronized static ObjectPool getPoolInstance(ObjectCreation_IF c, int max) {
        if(poolInstance == null) {
            poolInstance = new ObjectPool(c, max);
        }
        return poolInstance;
    }
    
    public int getSize() {
        return size;
    }
        
    public int getCapacity() {
        return maxInstances;
    }
    
    public void setCapacity(int c) {
        if(c <= 0) {
            String msg = "Capacity must be greater than zero:" + c;
            throw new IllegalArgumentException(msg);
        } // if
        synchronized(lockObject) {
            Object[] newPool = new Object[c];
            System.arraycopy(pool, 0, newPool, 0, c);
            pool = newPool;
        } // synchronized(lockObject)
    } //setCapacity()
    
    public synchronized Object getObject() {
        synchronized(lockObject) {
            if (instanceCount < getCapacity()) {
                return createObject();
            } else if(size > 0) {
                return removeObject();
            } else {
                return null;
            } // if
        } // synchronized
    } // getObject()

    public synchronized Object waitForObject() throws InterruptedException {
        synchronized(lockObject) {
            if (instanceCount < getCapacity()) {
                return createObject();
            } 
            else if(size > 0) {
                return removeObject();
            } 
            else {
                do {
                    // Wait until notified that an object has been put back into pool
                    wait();
                } while(size <= 0);
                return removeObject();
            } // if
        } // synchronized(lockObject)
    } // waitForObject()

    private Object removeObject() {
        size = size-1;
        return pool[size];
    }
    
    // copied straight from the textbook (pg 173)
    public void release(Object o) {
        // no nulls
        if(o == null) {
            throw new NullPointerException("Returned a null object to ObjectPool");
        } // if null
        synchronized(lockObject) {
            if(getSize() < getCapacity()) {
                pool[size] = o;
                size++;
                // Notify a waiting thread that we have put an object in the pool
                lockObject.notify();
            } // if
        } // synchronized        
    } // release ()

    private Object createObject() {
        pool[instanceCount] = creator.create();
        Object newObject = pool[instanceCount];
        instanceCount++;
        return newObject;
    }
    
}