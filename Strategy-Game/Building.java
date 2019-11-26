/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

/**
 *
 * @author Jack
 */
public abstract class Building implements GameObject_IF {
    
    private String buildName;
    private int[] position;
    
    public Building(String name){
        this.buildName = name;
    }
    
    public int[] getPosition(){
        return position;
    }
    public int[] getStartingPosition(){
        return new int[]{0, 0};
    }
    public ObjectIcon getObjectIcon(){
        return null;
    }
    public String getName(){
        return buildName;
    }
    
    public abstract void affectUnit(Unit u);
}
