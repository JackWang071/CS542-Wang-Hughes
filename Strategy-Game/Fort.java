package cs542_project;
/**
 *
 * @author Jack and Duran
 */
public class Fort extends Building implements Cloneable{
    //variables
    private static final int HP_RECOVERY = 0;
    private static final int ATTACK_BOOST = 0;
    private static final int DEFENSE_BOOST = 10;
    private static final String BUILDING_NAME = "Fort";
    
    //load in fort icon
    private static final ObjectIcon FORT_ICON = new ObjectIcon("projectgraphics/Fort.png");
    
    //constructor
    public Fort(){
        super(BUILDING_NAME, FORT_ICON, ATTACK_BOOST, DEFENSE_BOOST, HP_RECOVERY);
    }
}
