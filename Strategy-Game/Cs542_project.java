/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.io.*;
import java.util.Scanner;
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
        
        //IconTester();
        
        //loadFromFile();
    }
    
    public static void loadFromFile(){
        BufferedReader br;
        Scanner scanner;
        
        String pathname = "savefiles/save.txt";
        
        try{
            br = new BufferedReader(new FileReader(pathname));
            
            br.readLine();
            br.readLine();
            br.readLine();
            
            String nline = br.readLine();
            //Fragility is deliberate. Messing with the save file may wreck your save.
            //Reading data for armies.
            while(!nline.equals("B")){
                scanner = new Scanner(nline).useDelimiter("\\s*,\\s*");
                String[] pline = new String[]{scanner.next(), scanner.next()};
                for(String p : pline){
                    System.out.print(p + " ");
                }
                System.out.println();
                nline = br.readLine();
            }
            //Reading data for buildings.
            nline = br.readLine();
            while(!nline.equals("U")){
                scanner = new Scanner(nline).useDelimiter("\\s*,\\s*");
                String[] pline = new String[]{scanner.next(), scanner.next(), scanner.next()};
                System.out.print(pline[0] + " ");
                System.out.print(Integer.parseInt(pline[1]) + " ");
                System.out.print(Integer.parseInt(pline[2]) + " ");
                System.out.println();
                nline = br.readLine();
            }
            //Reading data for units.
            nline = br.readLine();
            while(!nline.equals("*")){
                scanner = new Scanner(nline).useDelimiter("\\s*,\\s*");
                String[] pline = new String[]{scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next()};
                for(String p : pline){
                    System.out.print(p + " ");
                }
                System.out.println();
                nline = br.readLine();
            }
            
            br.close();
        }
        catch(IOException ioe){
            System.out.println("Could not load saved game.");
        }
        catch(Exception e){
            System.out.println("Save file corrupted.");
        }
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
        
        ObjectIcon oi_1 = new ObjectIcon("projectgraphics/Cavalry3.png");
        ObjectIcon oi_2 = new ObjectIcon("projectgraphics/Village.jpg");
        
        icon1.setIcon(oi_1.returnIcon());
        icon2.setIcon(oi_2.returnIcon(90, 76));
        
        //button.add(icon1);
        button.add(icon2);
        button.setBackground(Color.RED);
        
        tester.setVisible(true);
    }
}
