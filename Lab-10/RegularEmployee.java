package cs542_a10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jack
 */
public class RegularEmployee extends Employee {
    
    public RegularEmployee(String name){
        super(name);
    }
    
    public void seeDanger(Hazard h){
        getDirectOverseer().seeDanger(h);
    }
    
    public void fixIt(){
        System.out.println("Employee " + getName() + "is fixing the problem.");
    }
}
