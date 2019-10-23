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
public class Novel extends CompositeArchiveElement {
    
    String ISBN;
    String title;
    
    public Novel(String num, String t){
        ISBN = num;
        title = t;
    }
    
    public void display() {
        System.out.println(ISBN);
        System.out.println(title);
        
        ArrayList<ArchiveElementIF> elements = getElements();
        for(ArchiveElementIF e : elements){
            e.display();
        }
    }
}
