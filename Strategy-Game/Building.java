/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.lang.Cloneable;
/**
 *
 * @author Jack
 */
public abstract class Building implements GameObject_IF, Cloneable {
    
    private int attack_boost;
    private int defense_boost;
    private int hp_recovery;
    private int[] position;
    private ObjectIcon icon;
    
    public Building(ObjectIcon icon, int attack, int defense, int hp_rec){
        this.attack_boost = attack;
        this.defense_boost = defense;
        this.hp_recovery = hp_rec;
        this.icon = icon;
    }
    
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public int[] getPosition(){
        return position;
    }
    public int[] setStartingPosition(int[] startPos){
        if(position == null){
            position = startPos;
        }
        return position;
    }
    public ObjectIcon getObjectIcon(){
        return icon;
    }
    
    public int getAttackBoost(){
        return attack_boost;
    }
    
    public int getDefenseBoost(){
        return defense_boost;
    }
    
    public int getHPRecovery(){
        return hp_recovery;
    }
}
