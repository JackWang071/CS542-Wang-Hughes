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
        
        env.setGrindingTime(5);
        env.setTemperature(200);
        env.holdTemperature(5);
        
        Condiment cream1 = new Cream();
        Condiment vanilla1 = new Vanilla();
        coffee.addCondiment(cream1);
        coffee.addCondiment(vanilla1);
        env.addCondiment(cream1);
        env.addCondiment(vanilla1);
        
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
