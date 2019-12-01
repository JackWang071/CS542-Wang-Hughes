/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Jack and Duran
 */
public class GameBoard extends JPanel {
    private GridSquare[][] grid;
    
    public GameBoard(int size){
        
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
    
    public GridSquare getSquare(int[] position){
        return grid[position[0]][position[1]];
    }
    
    public void updateNextTurn(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                grid[i][j].setAttackHereListener(null);
                grid[i][j].setMoveHereListener(null);
                grid[i][j].redrawIcons();
            }
        }
    }
    
    public void highlightAffectedUnits(Unit u, String purpose){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(purpose.equals("Attack")){
                    grid[i][j].setAttackHereListener(u);
                }
                else if (purpose.equals("Move")){
                    grid[i][j].setMoveHereListener(u);
                }
            }
        }
    }
    public void highlightLegalStartingPositions(Army army){
        
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        
        if(army.getArmyColor() == Color.RED){
            top = 2;
            bottom = grid.length - 2;
            left = 0;
            right = 2;
        }
        else if(army.getArmyColor() == Color.YELLOW){
            top = 2;
            bottom = grid.length - 2;
            left = grid.length - 2;
            right = grid.length;
        }
        else if(army.getArmyColor() == Color.GREEN){
            top = 0;
            bottom = 2;
            left = 2;
            right = grid.length - 2;
            
        }
        else if(army.getArmyColor() == Color.BLUE){
            top = grid.length - 2;
            bottom = grid.length;
            left = 2;
            right = grid.length - 2;
        }
        
        int[] this_coordinate = new int[]{0, 0};
        for(int i = top; i < bottom; i++){
            for(int j = left; j < right; j++){
                this_coordinate[0] = i;
                this_coordinate[1] = j;
                if(getSquare(this_coordinate).getOccupier() == null){
                    getSquare(this_coordinate).setBackground(army.getArmyColor());
                    getSquare(this_coordinate).addActionListener(new ArmySetupPanel.UnitPlacementListener());
                }
            }
        }
    }
    
    private class TileSelectListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            
        }
    }
}
