package cs542_project;
/**
 *
 * @author Jack and Duran
 */
public class Infantry extends Unit {
    //variables
    private static final String UNIT_NAME = "Infantry";
    private static final int BASE_HP = 100;
    private static final int UNIT_COST = 5;
    private static final int UNIT_RANGE = 1;
    private static final int BASE_MOVEMENT = 1;
    private static final int BASE_ATTACK = 20;
    private static final int BASE_DEFENSE = 8;
    
    //load in infantry icon
    private static final ObjectIcon INFANTRY_ICON = new ObjectIcon("projectgraphics/Infantry.png");
    
    //constructor
    public Infantry(Army army){
        super(UNIT_NAME, 
                army, 
                BASE_HP, 
                BASE_ATTACK, 
                BASE_MOVEMENT, 
                BASE_DEFENSE, 
                UNIT_RANGE, 
                UNIT_COST,
                INFANTRY_ICON);
    }
    
    //attacking function (overloaded so infantry can't attack after moving)
    public void attack(Unit target){
        if(can_attack()){
            target.changeHP(-(getAttack()));
        }
        finished_attacking();
        finished_moving();
    }
}
