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
        
        //Page 1 and elements
        Page p1 = new Page(1);
        Column p1c1 = new Column("Column 1");
        Column p1c2 = new Column("Column 2");
        LineOfText t1 = new LineOfText("Design an archive system to store novels.");
        LineOfText t2 = new LineOfText("A novel can have many pages.");
        LineOfText t3 = new LineOfText("Within a page, there can be several columns and frames.");
        LineOfText t4 = new LineOfText("This is a test image.");
        Image i1 = new Image("test image", 5, 5);
        p1c1.add(t1);
        p1c1.add(t2);
        p1c1.add(t3);
        p1c2.add(i1);
        p1c2.add(t4);
        p1.add(p1c1);
        p1.add(p1c2);
        
        //Page 2 and elements
        Page p2 = new Page(2);
        Column p2c1 = new Column("Column 1");
        LineOfText t5 = new LineOfText("This is a test line of text.");
        LineOfText t6 = new LineOfText("A frame has lines delineating the beginning and end of the frame.");
        Frame p2f1 = new Frame("This is a test frame.");
        Image i2 = new Image("test image 2", 7, 6);
        p2f1.add(i2);
        p2c1.add(t5);
        p2f1.add(p2c1);
        p2.add(t6);
        p2.add(p2f1);

        //Adding pages to novel
        n.add(p1);
        n.add(p2);
        n.display();
        
        
    }
    
}
