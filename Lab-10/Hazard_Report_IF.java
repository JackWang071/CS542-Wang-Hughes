package cs542_a10;

/**
 *
 * @author Jack
 */
public interface Hazard_Report_IF {
    
    void seeDanger(Hazard h);
    
    void setDirectOverseer(Hazard_Report_IF r);
    
    Hazard_Report_IF getDirectOverseer();
}
