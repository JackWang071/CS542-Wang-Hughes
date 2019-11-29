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
public class Infantry extends Unit {
    private static final int BASE_HP = 10;
    private static final int UNIT_COST = 10;
    private static final int UNIT_RANGE = 10;
    private static final int BASE_MOVEMENT = 10;
    private static final int BASE_ATTACK = 10;
    private static final int BASE_DEFENSE = 10;
    
    private static final ObjectIcon icon = new ObjectIcon();
    
    public Infantry(String name, Army army){
        super(army.getRace().getRaceName() + " Infantry " + name, 
                army, 
                BASE_HP, 
                BASE_ATTACK + army.getRace().getAttackBonus(), 
                BASE_MOVEMENT + army.getRace().getMoveBonus(), 
                BASE_DEFENSE + army.getRace().getDefBonus(), 
                UNIT_RANGE, 
                UNIT_COST,
                icon);
    }
    
    public int[] setStartingPosition(){
        return new int[]{0, 0};
    }
}
