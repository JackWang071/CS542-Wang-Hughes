package Lab10;

/**
 *
 * @author Jack and Duran
 */
public class FileReport  {
    
    String type;
    int hazard_lvl;
        
    public FileReport(String t, int hL,){
        type = t;
        hazard_lvl = hL;
    }
    
    public int getHazard_lvl() {
        return hazard_lvl;
    }
    
}
