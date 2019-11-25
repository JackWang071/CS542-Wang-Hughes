/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public class GameBoard {
    private GridSquare[][] grid;
    private static GameBoard the_board;
    
    private GameBoard(int size){
        grid = new GridSquare[size][size];
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
