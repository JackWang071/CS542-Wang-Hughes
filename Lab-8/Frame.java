/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs542_a8;

/**
 *
 * @author Jack and Duran
 */
public class Frame extends CompositeArchiveElement {
    
    boolean fitsPage; 
    
    public Frame(boolean fP){
        fitsPage = fP;
    }
    
    public void display() {
        System.out.println(fitsPage);  
        
        ArrayList<ArchiveElementIF> elements = getElements();
        for(ArchiveElementIF e : elements){
            e.display();
        }
    }
}
