package com.mycompany.assignment6;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 *
 * @author Duran and Jack
 */
//i believe ths should actually be public according to the textbook (pg 166)
public class ObjectPool extends ObjectPool_IF {
    
    private ObjectPool poolInstance;
    private int size;
    //private Object lockObject;
    private int maxInstances;
    
    //textbook stuff
    private Object[] pool;
    private Object lockObject = new Object();
    
    private ObjectPool(ObjectCreation_IF c, int capacity, int max) {
        //something = c
        size = 0;
        poolInstance = c;
        maxInstances = max;
        pool = (Object[]Array.newInstance(poolClass, capacity));
    }
    
    public static ObjectPool getPoolInstance(ObjectCreation_IF c, int capacity, int max) {
        if(poolInstance == null) {
            //stuff
        }
    }
    
    public int getSize() {
        return size;
    }
        
    public int getCapacity() {
        return pool.length;
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
    
    public Object getObject() {
        synchronized(lockObject) {
            if(size > 0) {
                return removeObject();
                // getInstanceCount = size  getMaxInstances = getCapacity()
            } else if (getInstanceCount() < getMaxInstances()) {
                return createObject();
            } else {
                return null;
            } // if
        } // synchronized
    } // getObject()

    public Object waitForObject() throws InterruptedException {
        synchronized(lockObject) {
            if(size > 0) {
                return removeObject();
            } else if (getInstanceCount() < getMaxInstances()) {
                return createObject();
            } else {
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
            throw new NullPointerException();
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
        
    }objectPool server = objectpool.getpoolinstance(new fbi-agen-ceator(), 5)'
    syste,.out.printl(servicer)
    forI i - 10)
            thread client = new thread(new taskrequester(server));
    client.start()
            
    while(thread.active ount >1
            
            syste,print its done'
            
    
    taskrequester
    
    public void run() {
        try {
            agentif agent = (agentif_ server.waitforObject()
            int taskid = rand.netInt(50)
                    agent.setTaskID
                            agent.startTask
                                    
                                  sleep
                                    stop
                                            sleep
                                            [rint
                                                    release])
        }
    })
    
}
