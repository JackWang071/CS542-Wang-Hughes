package cs542_a10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jack and Duran
 */
public class RegularEmployee extends Employee {
    
    public RegularEmployee(String name){
        super(name);
    }
    
    public void seeDanger(Hazard h){
        System.out.println("Employee " + getName() + " reports the hazard to their direct overseer.");
        getDirectOverseer().seeDanger(h);
    }
    
    public void fixIt(){
        System.out.println("Employee " + getName() + " is fixing the problem.");
    }
}
