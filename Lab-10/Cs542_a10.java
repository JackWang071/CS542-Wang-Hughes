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
public class Cs542_a10 {

    /**
     * @param args the command line arguments
     */
    
    /*
    There are two supervisors Jack and Jeff, and two project leaders Chuck and Denise. 
    Jack supervises regular employees John, Mary, Jane, Tom and Nick. 
    Jeff supervises Rob, Ed, Rick and Michael. 
    Chuck leads Joe, Frank, Sam and Greg. 
    Denise leads Amy, Wil, Nancy and Adam. 
    Bob is the manager of Jack and Jeff, while Rachel is the manager of Chuck and Denise. 
    The CEO is Steve. 
    
    */
    
    public static void main(String[] args) {
        CEO steve = new CEO("Steve");
        Manager bob = new Manager("Bob");
        Manager rachel = new Manager("Rachel");
        
        Supervisor jack = new Supervisor("Jack");
        Supervisor jeff = new Supervisor("Jeff");
        
        ProjectLead chuck = new ProjectLead("Chuck");
        ProjectLead denise = new ProjectLead("Denise");
        
        RegularEmployee john = new RegularEmployee("John");
        RegularEmployee mary = new RegularEmployee("Mary");
        RegularEmployee jane = new RegularEmployee("Jane");
        RegularEmployee tom = new RegularEmployee("Tom");
        RegularEmployee nick = new RegularEmployee("Nick");
        
        RegularEmployee rob = new RegularEmployee("Rob");
        RegularEmployee ed = new RegularEmployee("Ed");
        RegularEmployee rick = new RegularEmployee("Rick");
        RegularEmployee michael = new RegularEmployee("Michael");
        
        RegularEmployee amy = new RegularEmployee("Amy");
        RegularEmployee will = new RegularEmployee("Will");
        RegularEmployee nancy = new RegularEmployee("Nancy");
        RegularEmployee adam = new RegularEmployee("Adam");
        
        RegularEmployee joe = new RegularEmployee("Joe");
        RegularEmployee frank = new RegularEmployee("Frank");
        RegularEmployee sam = new RegularEmployee("Sam");
        RegularEmployee greg = new RegularEmployee("Greg");
        
        jack.addSubordinate(john);
        jack.addSubordinate(mary);
        jack.addSubordinate(jane);
        jack.addSubordinate(tom);
        jack.addSubordinate(nick);
        
        jeff.addSubordinate(rob);
        jeff.addSubordinate(ed);
        jeff.addSubordinate(rick);
        jeff.addSubordinate(michael);
        
        chuck.addSubordinate(joe);
        chuck.addSubordinate(frank);
        chuck.addSubordinate(sam);
        chuck.addSubordinate(greg);
        
        denise.addSubordinate(amy);
        denise.addSubordinate(will);
        denise.addSubordinate(nancy);
        denise.addSubordinate(adam);
        
        bob.addSubordinate(jack);
        bob.addSubordinate(jeff);
        
        rachel.addSubordinate(chuck);
        rachel.addSubordinate(denise);
        
        steve.addSubordinate(bob);
        steve.addSubordinate(rachel);
        
        Hazard test_hazard = new Hazard("fire", 4);
        
        john.seeDanger(test_hazard);
    }
    
}
