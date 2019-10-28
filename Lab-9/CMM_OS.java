/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a9;
import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 *
 * @author Jack and Duran
 */
public class CMM_OS implements CMM_OpenAPI_IF {
    
    private CMM_LoadableServer_IF currentServer;
    private ArrayList<Coffee> coffee_orders;
    DecimalFormat decim;
    
    public CMM_OS(){
        coffee_orders = new ArrayList();
        decim = new DecimalFormat("0.00");
    }
    
    public void setServer(CMM_LoadableServer_IF s){
        currentServer = s;
    }
    
    public void run(){
        currentServer.setEnvironment(this);
        currentServer.start();
    }
    
    public void setCoffeeType(String str){
        System.out.println("---------------------------------------------------");
        String message = "You have chosen: " + str;
        System.out.println(message);
    }
    public void setGrindingTime(int secs){
        String message = "Grinding coffee for " + secs + " seconds.";
        System.out.println(message);
    }
    public void addCondiment(Condiment type){
        String message = "Add " + type.getName() + ".";
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
        System.out.println();
        if(num == 0){
            System.out.print(num + "  ");
        }
        else{
            System.out.println(num + "  -");
            System.out.println();
        }
    }
    public void setTypeLED(int num){
        System.out.print(num);
        System.out.println();
        System.out.println();
    }
    public void computePrice(Coffee cif){
        coffee_orders.add(cif);
        String message = "Calculating total price: $" + decim.format(cif.getTotalPrice());
        System.out.println(message);
    }
    public void done(){
        currentServer = null;
        System.out.println("Transaction completed.");
    }
}
