/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a9;
import java.util.ArrayList;

/**
 *
 * @author Jack and Duran
 */
public class CMM_OS implements CMM_OpenAPI_IF {
    
    private CMM_LoadableServer_IF currentServer;
    private int server_type;
    private int running;
    private ArrayList<Coffee> coffee_orders;
    
    public CMM_OS(){
        running = 1;
    }
    
    public void setServer(CMM_LoadableServer_IF s){
        currentServer = s;
        currentServer.setEnvironment(this);
    }
    
    public void run(){
        currentServer.start();
    }
    
    public void setCoffeeType(String str){
        
    }
    public void setGrindingTime(int secs){
        String message = "Grinding coffee for " + secs + "seconds.";
        System.out.println(message);
    }
    public void addCondiment(Condiment type){
        String message = "Add " + type.getName();
        System.out.println(message);
    }
    public void setTemperature(int degree){
        String message = "Setting temperature to " + degree + " degrees Fahrenheit.";
        System.out.println(message);
    }
    public void holdTemperature(int seconds){
        String message = "Holding temperature for " + seconds + " seconds.";
        System.out.println(message);
    }
    public void setPowerLED(int num){
        running = num;
    }
    public void setTypeLED(int num){
        server_type = num;
    }
    public void computePrice(Coffee cif){
        coffee_orders.add(cif);
        String message = "Total price: " + cif.getPrice();
        System.out.println(message);
    }
    public void done(){
        running = 1;
        currentServer = null;
    }
}
