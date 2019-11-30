/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

/**
 *
 * @author Jack
 */
public class BuildingFactory {
    
    private Village village_proto;
    private Fort fort_proto;
    
    public BuildingFactory(){
        village_proto = new Village();
        fort_proto = new Fort();
    }
    
    public Building createBuilding(String type) throws CloneNotSupportedException {
        if(type.equals("Village")){
            return (Building) village_proto.clone();
        }
        else if (type.equals("Fort")){
            return (Building) fort_proto.clone();
        }
        return null;
    }
}
