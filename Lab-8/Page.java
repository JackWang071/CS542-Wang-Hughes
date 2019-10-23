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
public class Page extends CompositeArchiveElement {
    
    int pageNumber;
    
    ArrayList contents;
    
    public Page(int pN){
        pageNumber = pN;
        contents = getElements();
    }
    
    public void display() {
        System.out.println(pageNumber);
        
        ArrayList<ArchiveElementIF> elements = getElements();
        for(ArchiveElementIF e : elements){
            e.display();
        }
    }
}
