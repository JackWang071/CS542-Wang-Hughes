/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a8;
import java.util.ArrayList;
/**
 *
 * @author Jack
 */
public class CompositeArchiveElement implements ArchiveElementIF {
    
    private ArrayList<ArchiveElementIF> elements;
    
    public CompositeArchiveElement(){
        elements = new ArrayList();
    }
    
    public void add(ArchiveElementIF elem){
        elements.add(elem);
    }
    
    public void remove(int here){
        elements.remove(here);
    }
    
    public ArchiveElementIF get(int here){
        return elements.get(here);
    }
    
    public ArrayList<ArchiveElementIF> getElements(){
        return elements;
    }
    
    public void display(){
        for(ArchiveElementIF e : elements){
            e.display();
        }
    }
}
