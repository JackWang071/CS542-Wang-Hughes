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
public class FileReport extends Decision  {
        
    public FileReport(int p){
        super(p);
    }
    
    public void execute(CEO ceo){
        System.out.println("I want a report on this incident on my desk in the next 2 minutes");
    } 
    
}