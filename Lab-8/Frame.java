/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs542_a8;
import java.util.ArrayList;

/**
 *
 * @author Jack and Duran
 */
public class Frame extends CompositeArchiveElement {
    
    String caption; 
    
    public Frame(String cap){
        caption = cap;
    }
    
    public void display() {
        ArrayList<ArchiveElementIF> elements = getElements();
        System.out.println("-----------------------------------------------");
        for(ArchiveElementIF e : elements){
            e.display();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Caption: " + caption);
    }
}
