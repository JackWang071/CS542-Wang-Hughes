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
public class Page extends CompositeArchiveElement {
    
    int pageNumber;
    
    public Page(int pN){
        pageNumber = pN;
    }
    
    public void display() {
        System.out.println(pageNumber);
    }
}
