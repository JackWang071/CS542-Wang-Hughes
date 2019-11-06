package cs542_a10;

/**
 *
 * @author Jack and Duran
 */
public class Evacuation extends Decision {
    
    private String type;
    private int hazard_lvl;
    private int priority;
    
    public Evacuation(String t, int hL, int p){
        type = t;
        hazard_lvl = hL;
        priority = p;
    }
    
    public void execute(ceo CEO){
        System.out.println("I want a report on this incident on my desk in the next 2 minutes");
    } 
}
