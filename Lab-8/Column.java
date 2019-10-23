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
public class Column extends CompositeArchiveElement {
    
    String header;
    
    public Column(String header){
        this.header = header;
    }
    
    public void display(){
        System.out.println(header);
        ArrayList<ArchiveElementIF> elements = getElements();
        for(ArchiveElementIF e : elements){
            e.display();
        }
    }
}
