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
public class Espresso_Server implements CMM_LoadableServer_IF{
    private CMM_OpenAPI_IF env;
    
    public void setEnvironment(CMM_OpenAPI_IF env){
        this.env = env;
    }
    public void start(){
        env.setCoffeeType("Espresso");
        env.setPowerLED(0);
        env.setTypeLED(4);
        
        Coffee coffee = new Espresso();
        
        env.setGrindingTime(10);
        env.setTemperature(232);
        env.holdTemperature(240);
        
        try{
            Thread.sleep(1500);
        }
        catch(InterruptedException ie){
            System.out.println("Espresso server has been interrupted.");
        }
        
        env.setPowerLED(1);
        env.done();
        env.computePrice(coffee);
        env = null;
    }
}