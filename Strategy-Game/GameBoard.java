/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
/**
 *
 * @author Jack and Duran
 */
public class GameBoard extends JPanel {
    private GridSquare[][] grid;
    private static GameBoard the_board;
    
    private GameBoard(int size){
        
        this.setLayout(new GridLayout(size, size));
        this.setPreferredSize(new Dimension(700, 700));
        
        grid = new GridSquare[size][size];
        int[] currPos = new int[2];
        for(int i = 0; i < grid.length; i++){
            currPos[0] = i;
            for(int j = 0; j < grid[0].length; j++){
                currPos[1] = j;
                grid[i][j] = new GridSquare(currPos);
                this.add(grid[i][j]);
            }
        }
    }
    
    public static GameBoard getGameBoard(int size){
        if(the_board == null){
            the_board = new GameBoard(size);
        }
        return the_board;
    }
    
    public GridSquare getSquare(int[] position){
        return grid[position[0]][position[1]];
    }
}
