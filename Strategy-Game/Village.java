package cs542_project;
/**
 *
 * @author Jack and Duran
 */
public class Village extends Building implements Cloneable{
    //variables
    private static final int HP_RECOVERY = 10;
    private static final int ATTACK_BOOST = 0;
    private static final int DEFENSE_BOOST = 0;
    private static final String BUILDING_NAME = "Village";
    
    //load in village icon
    private static final ObjectIcon VILLAGE_ICON = new ObjectIcon("projectgraphics/Village.png");
    
    //constructor
    public Village(){
        super(BUILDING_NAME, VILLAGE_ICON, ATTACK_BOOST, DEFENSE_BOOST, HP_RECOVERY);
    }
    
    
}
