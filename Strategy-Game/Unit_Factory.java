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
            if(type.equals(archers_proto.getName()) && archers_proto.getCost() <= archers_proto.getArmy().getPointsLeft()){
                return (Unit) archers_proto.clone();
            }
            else if (type.equals(cavalry_proto.getName()) && cavalry_proto.getCost() <= cavalry_proto.getArmy().getPointsLeft()){
                return (Unit) cavalry_proto.clone();
            }
            else if (type.equals(infantry_proto.getName()) && infantry_proto.getCost() <= infantry_proto.getArmy().getPointsLeft()){
                return (Unit) infantry_proto.clone();
            }
            else if (type.equals(dragon_proto.getName()) && dragon_proto.getCost() <= dragon_proto.getArmy().getPointsLeft()){
                return (Unit) dragon_proto.clone();
            }
        }
        catch(CloneNotSupportedException cnse){}
        return null;
    }
    
    public Unit[] getUnitCatalog(){
        return new Unit[]{archers_proto, cavalry_proto, infantry_proto, dragon_proto};
    }
}
