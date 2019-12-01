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
public class Dwarf_Race implements Race {
    private static int ATTACK_BONUS = 0;
    private static int MOVE_BONUS = 0;
    private static int DEF_BONUS = 5;
    private static String RACE_NAME = "Dwarf";
    private static Dwarf_Race dwarf;
    
    
    private Dwarf_Race(){}
    
    public static Dwarf_Race getDwarfArchetype(){
        if(dwarf == null){
            dwarf = new Dwarf_Race();
        }
        return dwarf;
    }
    
    public int getAttackBonus(){
        return ATTACK_BONUS;
    }
    public int getMoveBonus(){
        return MOVE_BONUS;
    }
    public int getDefBonus(){
        return DEF_BONUS;
    }
    public String getRaceName(){
        return RACE_NAME;
    }
}
