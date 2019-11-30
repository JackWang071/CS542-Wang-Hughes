/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.lang.Cloneable;

/**
 *
 * @author Jack and Duran
 */
public abstract class Unit implements GameObject_IF, Cloneable{
    
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
    
    public Unit(String name, Army army, int hp, int attack, int move, int def, int range, int cost, ObjectIcon icon){
        this.unitName = name;
        this.army = army;
        this.HP = hp;
        this.attack = attack;
        this.defense = def;
        this.moveDist = move;
        this.range = range;
        this.cost = cost;
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
    
    public Army getArmy(){
        return army;
    }
    public String getName(){
        return army.getName() + " " + army.getRace().getRaceName() + " " + unitName;
    }
    public int getAttack(){
        return attack + army.getRace().getAttackBonus();
    }
    public int getDefense(){
        return defense + army.getRace().getDefBonus();
    }
    public int getRange(){
        return range;
    }
    public int getHP(){
        return HP;
    }
    public int getMoveDist(){
        return moveDist + army.getRace().getMoveBonus();
    }
    public int getCost(){
        return cost;
    }
    
    public void move(int[] new_position){
        position = new_position;
    }
    
    public void attack(Unit u){
        u.changeHP(-(attack + getAttack()));
    }
    
    public int changeHP(int amt){
        if (amt < 0){
            HP += (amt + getDefense());
        }
        else{
            HP += amt;
        }
        return HP;
    }
    
    public boolean is_destroyed(){
        return (HP <= 0);
    }
}
