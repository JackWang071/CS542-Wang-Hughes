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
public class Dragon extends Unit {
    private static final String UNIT_NAME = "Dragon Rider";
    private static final int BASE_HP = 100;
    private static final int UNIT_COST = 30;
    private static final int UNIT_RANGE = 3;
    private static final int BASE_MOVEMENT = 3;
    private static final int BASE_ATTACK = 30;
    private static final int BASE_DEFENSE = 15;
    
    private static final ObjectIcon DRAGON_ICON = new ObjectIcon("Dra");
    
    public Dragon(Army army){
        super(UNIT_NAME, 
                army, 
                BASE_HP, 
                BASE_ATTACK, 
                BASE_MOVEMENT, 
                BASE_DEFENSE, 
                UNIT_RANGE, 
                UNIT_COST,
                DRAGON_ICON);
    }
    
    public static int getUnitCost(){
        return UNIT_COST;
    }
}
