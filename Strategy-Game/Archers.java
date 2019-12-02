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
public class Archers extends Unit {
    private static final String UNIT_NAME = "Archers";
    private static final int BASE_HP = 30;
    private static final int UNIT_COST = 10;
    private static final int UNIT_RANGE = 3;
    private static final int BASE_MOVEMENT = 1;
    private static final int BASE_ATTACK = 30;
    private static final int BASE_DEFENSE = 5;
    
    private static final ObjectIcon ARCHERS_ICON = new ObjectIcon("Arc");
    
    public Archers(Army army){
        super(UNIT_NAME, 
                army, 
                BASE_HP, 
                BASE_ATTACK, 
                BASE_MOVEMENT, 
                BASE_DEFENSE, 
                UNIT_RANGE, 
                UNIT_COST,
                ARCHERS_ICON);
    }
}
