package cs542_a10;
/**
 *
 * @author Jack and Duran
 */
public abstract class Leader extends Admin{
    
    public Leader(String name){
        super(name);
    }
    
    public boolean getFeedback(Hazard h){
        
        return false;
    }
    
}
