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
public class Cs542_a8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Novel n = new Novel("1234", "Test Novel");
        
        Page p1 = new Page(1);
        Page p2 = new Page(2);
        
        Column p1c1 = new Column("Column 1");
        Column p1c2 = new Column("Column 2");
        
        LineOfText t1 = new LineOfText();
        
        
        
    }
    
}
