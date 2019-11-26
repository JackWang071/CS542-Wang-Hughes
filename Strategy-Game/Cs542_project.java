/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.*;

/**
 *
 * @author Jack
 */
public class Cs542_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example");  
        JButton b=new JButton("Click Here");  
        b.setBounds(50,100,95,30);  
        f.add(b);  
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);
    }
    
}
