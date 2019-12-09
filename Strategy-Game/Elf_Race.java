package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public class Elf_Race implements Race {
    //variables
    private static int ATTACK_BONUS = 0;
    private static int MOVE_BONUS = 1;
    private static int DEF_BONUS = 0;
    private static int RANGE_BONUS = 1;
    private static String RACE_NAME = "Elf";
    private static Elf_Race elf;
    
    //constructor
    private Elf_Race(){}
    
    //gets archetype
    public static Elf_Race getElfArchetype(){
        if(elf == null){
            elf = new Elf_Race();
        }
        return elf;
    }
    
    //getters
    public int getAttackBonus(){
        return ATTACK_BONUS;
    }
    public int getMoveBonus(){
        return MOVE_BONUS;
    }
    public int getDefBonus(){
        return DEF_BONUS;
    }
    public int getRangeBonus(){
        return RANGE_BONUS;
    }
    public String getRaceName(){
        return RACE_NAME;
    }
    
}
