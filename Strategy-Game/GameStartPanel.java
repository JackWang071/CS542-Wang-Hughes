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
    
    private JButton two_players;
    private JButton three_players;
    private JButton four_players;
    private GameGUI the_gui;
    
    private JButton gamestart_finish;
    
    private int final_board_size;
    private int final_num_players;
    
    public GameStartPanel(GameGUI the_gui){
        this.setPreferredSize(new Dimension(400, 700));
        this.the_gui = the_gui;
        
        this.final_board_size = 0;
        int final_num_players = 0;
        
        option_8x8 = new JButton("8x8");
        option_10x10 = new JButton("10x10");
        option_12x12 = new JButton("12x12");
        
        option_8x8.setPreferredSize(new Dimension(100, 50));
        option_10x10.setPreferredSize(new Dimension(100, 50));
        option_12x12.setPreferredSize(new Dimension(100, 50));
        
        two_players = new JButton("2 Players");
        three_players = new JButton("3 Players");
        four_players = new JButton("4 Players");
        
        two_players.setPreferredSize(new Dimension(100, 50));
        three_players.setPreferredSize(new Dimension(100, 50));
        four_players.setPreferredSize(new Dimension(100, 50));
        
        gamestart_finish = new JButton("Next");
        gamestart_finish.setPreferredSize(new Dimension(100, 50));
        
    }
    
    public void chooseStartingOptions(){
        option_8x8.addActionListener(new BoardSizeListener(8));
        option_10x10.addActionListener(new BoardSizeListener(10));
        option_12x12.addActionListener(new BoardSizeListener(12));
        
        this.add(option_8x8);
        this.add(option_10x10);
        this.add(option_12x12);
        
        
        two_players.addActionListener(new NumPlayersListener(2));
        three_players.addActionListener(new NumPlayersListener(3));
        four_players.addActionListener(new NumPlayersListener(4));
        
        this.add(two_players);
        this.add(three_players);
        this.add(four_players);
        
        gamestart_finish.addActionListener(new FinishGameStartListener());
        this.add(gamestart_finish);
    }
    
    public class BoardSizeListener implements ActionListener{
        private int board_size;
        
        public BoardSizeListener(int size){
            board_size = size;
        }
        
        public void actionPerformed(ActionEvent e){
            final_board_size = board_size;
        }
    }
    
    public class NumPlayersListener implements ActionListener{
        private int num_players;
        
        public NumPlayersListener(int num_players){
            this.num_players = num_players;
        }
        
        public void actionPerformed(ActionEvent e){
            final_num_players = num_players;
        }
    }
 
    public class FinishGameStartListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            if(final_num_players > 0 && final_board_size > 0){
                the_gui.getManager().createArmies(final_num_players);
                the_gui.showBoard(final_board_size);
                the_gui.showArmySetup();
            }
        }
    }
}
