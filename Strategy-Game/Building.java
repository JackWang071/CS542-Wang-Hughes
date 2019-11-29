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
    
    private int attack_boost;
    private int defense_boost;
    private int hp_recovery;
    private int[] position;
    
    public Building(int attack, int defense, int hp_rec){
        this.attack_boost = attack;
        this.defense_boost = defense;
        this.hp_recovery = hp_rec;
    }
    
    public int[] getPosition(){
        return position;
    }
    public int[] setStartingPosition(){
        return new int[]{0, 0};
    }
    public ObjectIcon getObjectIcon(){
        return null;
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
