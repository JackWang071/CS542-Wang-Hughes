/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public class Unit_Factory {
    
    private Archers archers_proto;
    private Cavalry cavalry_proto;
    private Infantry infantry_proto;
    private Dragon dragon_proto;
    
    public Unit_Factory(Army army){
        archers_proto = new Archers(army);
        cavalry_proto = new Cavalry(army);
        infantry_proto = new Infantry(army);
        dragon_proto = new Dragon(army);
    }
    
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
    
    public Unit[] getUnitCatalog(){
        return new Unit[]{archers_proto, cavalry_proto, infantry_proto, dragon_proto};
    }
    
    private boolean can_be_created(String type, Unit u){
        return type.equals(u.getName()) && u.getCost() <= u.getArmy().getPointsLeft();
    }
}
