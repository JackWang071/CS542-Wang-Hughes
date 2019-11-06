/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a10;

/**
 *
 * @author Jack and Duran
 */
public abstract class Employee implements Hazard_Report_IF {
    
    private String name;
    private Hazard_Report_IF superior;
    
    public Employee(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setDirectOverseer(Hazard_Report_IF r){
        superior = r;
    }
    
    public Hazard_Report_IF getDirectOverseer(){
        if(superior != null){
            return superior;
        }
        return null;
    }
    
    public void evacuate(){
        System.out.println(name + " is evacuating.");
    }
}
