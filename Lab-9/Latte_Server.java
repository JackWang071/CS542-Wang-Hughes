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

public class Latte_Server implements CMM_LoadableServer_IF{
    
    private CMM_OpenAPI_IF env;
    
    public Latte_Server(){
        
    }
    
    public void setEnvironment(CMM_OpenAPI_IF env){
        this.env = env;
    }
    
    public void start(){
        env.setCoffeeType("Latte");
        env.setPowerLED(0);
        env.setTypeLED(3);
        
        Coffee coffee = new Latte();
        
        env.setGrindingTime(5);
        env.setTemperature(200);
        env.holdTemperature(30);
        
        Condiment cream1 = new Cream();
        Condiment chocolate1 = new Chocolate();
        coffee.addCondiment(cream1);
        coffee.addCondiment(chocolate1);
        env.addCondiment(cream1);
        env.addCondiment(chocolate1);
        
        try{
            Thread.sleep(1500);
        }
        catch(InterruptedException ie){
            System.out.println("Latte server has been interrupted.");
        }
        
        env.setPowerLED(1);
        env.done();
        env.computePrice(coffee);
        env = null;
    }
}