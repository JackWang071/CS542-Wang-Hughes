package com.mycompany.assignment6;

import java.util.ArrayList;

/**
 *
 * @author Duran and Jack
 */
//i believe ths should actually be public according to the textbook (pg 166)
public class ObjectPool extends ObjectPool_IF {
    
    private ObjectPool poolInstance;
    private int size;
    private Object lockObject;
    private int maxInstances;
    
}
