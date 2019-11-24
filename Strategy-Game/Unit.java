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
public abstract class Unit implements GameObject_IF{
    
    private String unitName;
    private int attack;
    private int moveDist;
    private int defense;
    private int range;
    private int HP;
    private int[] position;
    private int cost;
    private Army army;
    private ObjectIcon icon;
    
    public Unit(String name, Army army, int hp, int attack, int move, int def, int range, int cost){
        
    }
    
    public int[] getPosition(){
        return position;
    }
    public int[] getStartingPosition(){
        return new int[]{0, 0};
    }
    public ObjectIcon getIcon(){
        return icon;
    }
}
