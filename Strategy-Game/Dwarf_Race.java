package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public class Dwarf_Race implements Race {
    //variables
    private static int ATTACK_BONUS = 0;
    private static int MOVE_BONUS = 0;
    private static int DEF_BONUS = 5;
    private static int RANGE_BONUS = 0;
    private static String RACE_NAME = "Dwarf";
    private static Dwarf_Race dwarf;
    
    //constructor
    private Dwarf_Race(){}
    
    //gets archetype
    public static Dwarf_Race getDwarfArchetype(){
        if(dwarf == null){
            dwarf = new Dwarf_Race();
        }
        return dwarf;
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
