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
    private int maxHP;
    private GridSquare position;
    private int cost;
    private Army army;
    private ObjectIcon icon;
    
    private boolean can_move;
    private boolean can_attack;
    
    public Unit(String name, Army army, int hp, int attack, int move, int def, int range, int cost, ObjectIcon icon){
        this.unitName = name;
        this.army = army;
        this.HP = hp;
        this.maxHP = hp;
        this.attack = attack;
        this.defense = def;
        this.moveDist = move;
        this.range = range;
        this.cost = cost;
        this.icon = icon;
    }
    
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public GridSquare getPosition(){
        return position;
    }
    public void setStartingPosition(GridSquare startPos){
        if(position == null){
            position = startPos;
        }
    }
    public ObjectIcon getObjectIcon(){
        return icon;
    }
    
    public Army getArmy(){
        return army;
    }
    public String getName(){
        return army.getRace().getRaceName() + " " + unitName;
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
    
    public void move(GridSquare new_position){
        if(can_move()){
            position.setOccupier(null);
            position.redrawIcons();
            position = new_position;
            position.setOccupier(this);
            position.redrawIcons();
        }
        finished_moving();
    }
    
    public void attack(Unit target){
        if(can_attack()){
            target.changeHP(-(getAttack() - getAttackModifier(target)));
        }
        finished_attacking();
        finished_moving();
    }
    
    protected int getAttackModifier(Unit target){
        int def_modifier = 0;
        if(target.getPosition().getBuilding() != null){
            def_modifier = target.getPosition().getBuilding().getDefenseBoost();
        }
        return def_modifier;
    }
    
    protected int changeHP(int amt){
        if (amt < 0){
            HP += (amt + getDefense());
        }
        else{
            HP += amt;
            if(HP > maxHP){
                HP = maxHP;
            }
        }
        return HP;
    }
    
    public void updateStatus(){
        if(!is_destroyed()){
            can_move = true;
            can_attack = true;
            
            if(getPosition().getBuilding() != null){
                changeHP(getPosition().getBuilding().getHPRecovery());
            }
        }
    }
    protected void finished_attacking(){
        can_attack = false;
    }
    protected void finished_moving(){
        can_move = false;
    }
    public boolean can_attack(){
        return can_attack;
    }
    public boolean can_move(){
        return can_move;
    }
    
    public boolean is_destroyed(){
        return (HP <= 0);
    }
    
    public String toString(){
        return getArmy().getName()
                + "\n " + getName() 
                + "\n HP: " + getHP() + "/" + maxHP
                + "\n Attack: " + getAttack()
                + "\n Defense: " + getDefense()
                + "\n Movement: " + getMoveDist()
                + "\n Range: " + getRange()
                + "\n";
    }
}
