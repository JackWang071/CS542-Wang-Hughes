package cs542_project;
/**
 *
 * @author Jack and Duran
 */
public class Cavalry extends Unit {
    //variables
    private static final String UNIT_NAME = "Cavalry";
    private static final int BASE_HP = 60;
    private static final int UNIT_COST = 10;
    private static final int UNIT_RANGE = 1;
    private static final int BASE_MOVEMENT = 3;
    private static final int BASE_ATTACK = 25;
    private static final int BASE_DEFENSE = 10;
    
    //load cavalry icon
    private static final ObjectIcon CAVALRY_ICON = new ObjectIcon("projectgraphics/Cavalry.png");
    
    //constructor
    public Cavalry(Army army){
        super(UNIT_NAME, 
                army, 
                BASE_HP, 
                BASE_ATTACK, 
                BASE_MOVEMENT, 
                BASE_DEFENSE, 
                UNIT_RANGE, 
                UNIT_COST,
                CAVALRY_ICON);
    }
}
