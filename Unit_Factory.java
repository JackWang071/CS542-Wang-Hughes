/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public class Unit_Factory {
    
    private Army army;
    
    public Unit_Factory(Army army){
        this.army = army;
    }
    
    public Unit createUnit(String type, String name){
        if(type == "Archers"){
            return new Archers(name, army);
        }
        else if (type == "Cavalry"){
            return new Cavalry(name, army);
        }
        else{
            return new Infantry(name, army);
        }
    }
}
