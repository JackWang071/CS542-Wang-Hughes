package cs542_a10;

/**
 *
 * @author Jack and Duran
 */
public class RegularEmployee extends Employee {
    
    public RegularEmployee(String name){
        super(name);
    }
    
    public void seeDanger(Hazard h){
        getDirectOverseer().seeDanger(h);
    }
    
    public void fixIt(){
        System.out.println("Employee " + getName() + "is fixing the problem.");
    }
}
