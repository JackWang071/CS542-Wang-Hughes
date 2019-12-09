package cs542_project;
/**
 *
 * @author Jack and Duran
 */
public class Archers extends Unit {
    //variables
    private static final String UNIT_NAME = "Archers";
    private static final int BASE_HP = 30;
    private static final int UNIT_COST = 10;
    private static final int UNIT_RANGE = 3;
    private static final int BASE_MOVEMENT = 1;
    private static final int BASE_ATTACK = 30;
    private static final int BASE_DEFENSE = 5;
    
    //create archer icon
    private static final ObjectIcon ARCHERS_ICON = new ObjectIcon("projectgraphics/Archer.png");
    
    //constructor
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
