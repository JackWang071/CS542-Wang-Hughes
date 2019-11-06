
package cs542_a10;

/**
 *
 * @author Jack and Duran
 */
public class FileReport extends Decision  {
        
    public FileReport(String t, int hL, int p){
        super(t, hL, p);
    }
    
    public int getHazard_lvl() {
        return hazard_lvl;
    }
    
    public void execute(CEO ceo){
        System.out.println("I want a report on this incident on my desk in the next 2 minutes");
    } 
    
}
