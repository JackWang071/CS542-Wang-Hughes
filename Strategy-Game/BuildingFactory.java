/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.util.Random;

/**
 *
 * @author Jack
 */
public class BuildingFactory {
    
    private Village village_proto;
    private Fort fort_proto;
    private Random rng;
    
    public BuildingFactory(){
        village_proto = new Village();
        fort_proto = new Fort();
        
        rng = new Random();
    }
    
    public Building createBuilding(String type) {
        try{
            if(type.equals(village_proto.getName())){
                return (Building) village_proto.clone();
            }
            else if (type.equals(fort_proto.getName())){
                return (Building) fort_proto.clone();
            }
        }
        catch (CloneNotSupportedException cnse) {}
        return null;
    }
    
    public Building getRandomBuilding(){
        if(rng.nextFloat() <= 0.5){
            return createBuilding(village_proto.getName());
        }
        else{
            return createBuilding(fort_proto.getName());
        }
    }
}
