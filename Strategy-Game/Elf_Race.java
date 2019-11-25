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
public class Elf_Race implements Race {
    private static int ATTACK_BONUS;
    private static int MOVE_BONUS;
    private static int DEF_BONUS;
    private static String RACE_NAME = "Elf";
    private static Elf_Race elf;
    
    
    private Elf_Race(){}
    
    public static Elf_Race getElfArchetype(){
        if(elf == null){
            elf = new Elf_Race();
        }
        return elf;
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