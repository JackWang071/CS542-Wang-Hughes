/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;


import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.io.File;
/**
 *
 * @author Jack and Duran
 */
public class Cs542_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameManager test = new GameManager();
    }
    
    public static void IconTester(){
        JFrame tester = new JFrame();
        tester.setLayout(new BorderLayout());
        tester.setSize(500, 500);
        JPanel tpanel = new JPanel();
        tpanel.setPreferredSize(new Dimension(200, 200));
        tester.add(tpanel);
        
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(100, 100));
        tpanel.add(button, BorderLayout.NORTH);
        
        JLabel icon1 = new JLabel();
        JLabel icon2 = new JLabel();
        
        try {
            Image img = ImageIO.read(new File("projectgraphics/Cavalry.png"));
            Image img2 = ImageIO.read(new File("projectgraphics/Village.png"));
            icon1.setIcon(new ImageIcon(img));
            icon2.setIcon(new ImageIcon(img2));
            
            button.add(icon1);
            //button.add(icon2);
            button.setBackground(Color.RED);
            
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
        tester.setVisible(true);
    }
}
