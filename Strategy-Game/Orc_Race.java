package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public class Orc_Race implements Race {
    //variables
    private static int ATTACK_BONUS = 5;
    private static int MOVE_BONUS = 0;
    private static int DEF_BONUS = 0;
    private static int RANGE_BONUS = 0;
    private static String RACE_NAME = "Orc";
    private static Orc_Race orc;
    
    //constructor
    private Orc_Race(){}
    
    //gets archetype
    public static Orc_Race getOrcArchetype(){
        if(orc == null){
            orc = new Orc_Race();
        }
        return orc;
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
