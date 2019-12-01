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
    
    public Unit_Factory(Army army){
        archers_proto = new Archers(army);
        cavalry_proto = new Cavalry(army);
        infantry_proto = new Infantry(army);
    }
    
    public Unit createUnit(String type) throws CloneNotSupportedException {
        if(type.equals("Archers") && archers_proto.getCost() < archers_proto.getArmy().getPointsLeft()){
            return (Unit) archers_proto.clone();
        }
        else if (type.equals("Cavalry") && cavalry_proto.getCost() < cavalry_proto.getArmy().getPointsLeft()){
            return (Unit) cavalry_proto.clone();
        }
        else if (type.equals("Infantry") && infantry_proto.getCost() < infantry_proto.getArmy().getPointsLeft()){
            return (Unit) infantry_proto.clone();
        }
        return null;
    }
}
