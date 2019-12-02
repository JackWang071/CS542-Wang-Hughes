/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
/**
 *
 * @author Jack and Duran
 */
public class Infantry extends Unit {
    private static final String UNIT_NAME = "Infantry";
    private static final int BASE_HP = 100;
    private static final int UNIT_COST = 5;
    private static final int UNIT_RANGE = 1;
    private static final int BASE_MOVEMENT = 1;
    private static final int BASE_ATTACK = 20;
    private static final int BASE_DEFENSE = 8;
    
    private static final ObjectIcon INFANTRY_ICON = new ObjectIcon("Inf");
    
    public Infantry(Army army){
        super(UNIT_NAME, 
                army, 
                BASE_HP, 
                BASE_ATTACK, 
                BASE_MOVEMENT, 
                BASE_DEFENSE, 
                UNIT_RANGE, 
                UNIT_COST,
                INFANTRY_ICON);
    }
    
    public static int getUnitCost(){
        return UNIT_COST;
    }
    
    public void attack(Unit target){
        if(can_attack()){
            target.changeHP(-(getAttack()));
        }
        finished_attacking();
        finished_moving();
    }
}
