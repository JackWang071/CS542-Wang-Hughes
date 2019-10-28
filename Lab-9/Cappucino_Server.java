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
public class Cappucino_Server implements CMM_LoadableServer_IF {
    private CMM_OpenAPI_IF env;
    
    public void setEnvironment(CMM_OpenAPI_IF env){
        this.env = env;
    }
    public void start(){
        env.setCoffeeType("Cappucino");
        env.setPowerLED(0);
        env.setTypeLED(5);
        
        Coffee coffee = new Cappucino();
        
        env.setGrindingTime(10);
        env.setTemperature(232);
        env.holdTemperature(240);
        
        Condiment cream1 = new Cream();
        coffee.addCondiment(cream1);
        env.addCondiment(cream1);
        
        try{
            Thread.sleep(1500);
        }
        catch(InterruptedException ie){
            System.out.println("Cappucino server has been interrupted.");
        }
        
        env.setPowerLED(1);
        env.done();
        env.computePrice(coffee);
        env = null;
    }
}
