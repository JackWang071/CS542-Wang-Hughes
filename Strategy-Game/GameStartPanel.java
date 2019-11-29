/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Jack
 */
public class GameStartPanel extends JPanel {
    
    private JButton option_8x8;
    private JButton option_10x10;
    private JButton option_12x12;
    private GameGUI the_gui;
    
    public GameStartPanel(GameGUI the_gui){
        this.setPreferredSize(new Dimension(400, 700));
        this.the_gui = the_gui;
        
        JButton option_8x8 = new JButton("8x8");
        JButton option_10x10 = new JButton("10x10");
        JButton option_12x12 = new JButton("12x12");
        
        option_8x8.setPreferredSize(new Dimension(100, 50));
        option_10x10.setPreferredSize(new Dimension(100, 50));
        option_12x12.setPreferredSize(new Dimension(100, 50));
        
        option_8x8.addActionListener(new BoardSizeListener(8));
        option_10x10.addActionListener(new BoardSizeListener(10));
        option_12x12.addActionListener(new BoardSizeListener(12));
        
        this.add(option_8x8);
        this.add(option_10x10);
        this.add(option_12x12);
    }
    
    
    
    public class BoardSizeListener implements ActionListener{
        
        private int board_size;
        
        public BoardSizeListener(int size){
            board_size = size;
        }
        
        public void actionPerformed(ActionEvent e){
            the_gui.boardSetup(board_size);
        }
    }
    
}
