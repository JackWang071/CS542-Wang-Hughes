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
public class Orc_Race implements Race {
    private static int ATTACK_BONUS = 5;
    private static int MOVE_BONUS = 0;
    private static int DEF_BONUS = 0;
    private static String RACE_NAME = "Orc";
    private static Orc_Race orc;
    
    
    private Orc_Race(){}
    
    public static Orc_Race getOrcArchetype(){
        if(orc == null){
            orc = new Orc_Race();
        }
        return orc;
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
