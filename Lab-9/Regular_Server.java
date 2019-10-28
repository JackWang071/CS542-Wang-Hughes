/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a9;

/**
 *
 * @author Jack and Duran
 */
public class Regular_Server implements CMM_LoadableServer_IF{
    
    private CMM_OpenAPI_IF env;
    
    public Regular_Server(){
    }
    
    public void setEnvironment(CMM_OpenAPI_IF env){
        this.env = env;
    }
    public void start(){
        env.setCoffeeType("Regular");
        env.setPowerLED(0);
        env.setTypeLED(1);
        
        Coffee coffee = new Regular();
        
        env.setGrindingTime(8);
        env.setTemperature(150);
        env.holdTemperature(2);
        
        try{
            Thread.sleep(1500);
        }
        catch(InterruptedException ie){
            System.out.println("Regular server has been interrupted.");
        }
        
        env.setPowerLED(1);
        env.done();
        env.computePrice(coffee);
        env = null;
    }
}
