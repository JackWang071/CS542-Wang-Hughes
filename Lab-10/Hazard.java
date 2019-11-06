package cs542_a10;

/**
 *
 * @author Jack and Duran
 */
public class Hazard {
    
    private String type;
    private int hazard_lvl;
    
    public Hazard(String t, int hL){
        type = t;
        hazard_lvl = hL;
    }
    
    public int getHazard_lvl(){
        return hazard_lvl;
    }
    
}
