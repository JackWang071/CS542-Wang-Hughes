package cs542_project;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Jack
 */
public class GameStartPanel extends JPanel {
    
    //variables
    private JPanel board_size_selection;
    private JPanel num_players_selection;
    private GameGUI the_gui;
    
    private JButton gamestart_finish;
    private JButton load_game;
    
    private int final_board_size;
    private int final_num_players;
    
    //constructor
    public GameStartPanel(GameGUI the_gui){
        this.setPreferredSize(new Dimension(400, 700));
        this.the_gui = the_gui;
        
        this.final_board_size = 0;
        this.final_num_players = 0;
        
        //select board size section
        board_size_selection = new JPanel();
        board_size_selection.setPreferredSize(new Dimension(1200, 150));
        JLabel board_size_selection_title = new JLabel("Choose Board Size", SwingConstants.CENTER);
        board_size_selection_title.setPreferredSize(new Dimension(1200, 30));
        board_size_selection.add(board_size_selection_title);
        
        //buttons for 8x8, 10x10, 12x12 options
        JButton option_8x8 = new JButton("8x8");
        JButton option_10x10 = new JButton("10x10");
        JButton option_12x12 = new JButton("12x12");
        option_8x8.setPreferredSize(new Dimension(100, 50));
        option_10x10.setPreferredSize(new Dimension(100, 50));
        option_12x12.setPreferredSize(new Dimension(100, 50));
        option_8x8.addActionListener(new BoardSizeListener(8));
        option_10x10.addActionListener(new BoardSizeListener(10));
        option_12x12.addActionListener(new BoardSizeListener(12));
        board_size_selection.add(option_8x8);
        board_size_selection.add(option_10x10);
        board_size_selection.add(option_12x12);
        
        //choose number of players section
        num_players_selection = new JPanel();
        num_players_selection.setPreferredSize(new Dimension(1200, 200));
        JLabel num_players_selection_title = new JLabel("Choose Number of Players", SwingConstants.CENTER);
        num_players_selection_title.setPreferredSize(new Dimension(1200, 30));
        num_players_selection.add(num_players_selection_title);
        
        //buttons for 2,3, and 4 player options
        JButton two_players = new JButton("2 Players");
        JButton three_players = new JButton("3 Players");
        JButton four_players = new JButton("4 Players");
        two_players.setPreferredSize(new Dimension(100, 50));
        three_players.setPreferredSize(new Dimension(100, 50));
        four_players.setPreferredSize(new Dimension(100, 50));
        two_players.addActionListener(new NumPlayersListener(2));
        three_players.addActionListener(new NumPlayersListener(3));
        four_players.addActionListener(new NumPlayersListener(4));
        num_players_selection.add(two_players);
        num_players_selection.add(three_players);
        num_players_selection.add(four_players);
        
        //next button
        gamestart_finish = new JButton("Next");
        gamestart_finish.setPreferredSize(new Dimension(100, 50));
        gamestart_finish.addActionListener(new FinishGameStartListener());
        
        //load game button
        load_game = new JButton("Load Game");
        load_game.setPreferredSize(new Dimension(200, 50));
        load_game.addActionListener(new LoadGameListener());
        
    }
    
    //buttons for starting menu
    public void chooseStartingOptions(){
        this.add(board_size_selection);
        this.add(num_players_selection);
        this.add(gamestart_finish);
        this.add(load_game);
    }
    
    //listeners below
    private class BoardSizeListener implements ActionListener{
        private int board_size;
        
        public BoardSizeListener(int size){
            board_size = size;
        }
        
        public void actionPerformed(ActionEvent e){
            final_board_size = board_size;
            for(Component c : board_size_selection.getComponents()){
                c.setBackground(null);
                if(c.equals(e.getSource())){
                    c.setBackground(Color.CYAN);
                }
            }
        }
    }
    
    private class NumPlayersListener implements ActionListener{
        private int num_players;
        
        public NumPlayersListener(int num_players){
            this.num_players = num_players;
        }
        
        public void actionPerformed(ActionEvent e){
            final_num_players = num_players;
            for(Component c : num_players_selection.getComponents()){
                c.setBackground(null);
                if(c.equals(e.getSource())){
                    c.setBackground(Color.CYAN);
                }
            }
        }
    }
 
    private class FinishGameStartListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(final_num_players > 0 && final_board_size > 0){
                the_gui.getManager().loadServer(InitialSetupServer.getServer(final_board_size, final_num_players));
            }
        }
    }
    
    private class LoadGameListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            the_gui.getManager().loadServer(LoadSaveGameServer.getServer());
        }
    }
}
