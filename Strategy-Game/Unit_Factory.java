package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public class Unit_Factory {
    //variables
    private Archers archers_proto;
    private Cavalry cavalry_proto;
    private Infantry infantry_proto;
    private Dragon dragon_proto;
    
    //constructors
    public Unit_Factory(Army army){
        archers_proto = new Archers(army);
        cavalry_proto = new Cavalry(army);
        infantry_proto = new Infantry(army);
        dragon_proto = new Dragon(army);
    }
    
    //generates requested units
    public Unit createUnit(String type) {
        try{
            if(can_be_created(type, archers_proto)){
                return (Unit) archers_proto.clone();
            }
            else if (can_be_created(type, cavalry_proto)){
                return (Unit) cavalry_proto.clone();
            }
            else if (can_be_created(type, infantry_proto)){
                return (Unit) infantry_proto.clone();
            }
            else if (can_be_created(type, dragon_proto)){
                return (Unit) dragon_proto.clone();
            }
        }
        catch(CloneNotSupportedException cnse){}
        return null;
    }
    
    //returns list of possible units
    public Unit[] getUnitCatalog(){
        return new Unit[]{archers_proto, cavalry_proto, infantry_proto, dragon_proto};
    }
    
    //calculates if player has enough points for requested unit
    private boolean can_be_created(String type, Unit u){
        return type.equals(u.getName()) && u.getCost() <= u.getArmy().getPointsLeft();
    }
}
