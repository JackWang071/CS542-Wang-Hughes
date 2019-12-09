package cs542_project;
import java.util.Random;

/**
 *
 * @author Jack
 */
public class BuildingFactory {
    //vairables
    private Village village_proto;
    private Fort fort_proto;
    private Random rng;
    
    //constructor
    public BuildingFactory(){
        village_proto = new Village();
        fort_proto = new Fort();
        
        rng = new Random();
    }
    
    //generates requested building
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
    
    //generates random building
    public Building getRandomBuilding(){
        if(rng.nextFloat() <= 0.5){
            return createBuilding(village_proto.getName());
        }
        else{
            return createBuilding(fort_proto.getName());
        }
    }
}
