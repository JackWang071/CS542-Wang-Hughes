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
import java.util.List;
import java.util.Random;
/**
 *
 * @author Jack and Duran
 */
public class GameBoard extends JPanel {
    private GridSquare[][] grid;
    private GameGUI the_gui;
    
    public GameBoard(GameGUI the_gui){
        this.the_gui = the_gui;
        this.setPreferredSize(new Dimension(700, 700));
    }
    
    public void createBoard(int size){
        setLayout(new GridLayout(size, size));
        grid = new GridSquare[size][size];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = new GridSquare(new int[]{i, j});
                this.add(grid[i][j]);
                grid[i][j].addActionListener(new TileSelectListener());
            }
        }
    }
    
    public GridSquare getSquare(int[] position){
        return grid[position[0]][position[1]];
    }
    
    public void addBuildings(List<Building> buildings){
        int counter = 0;
        Random rng = new Random();
        do{
            for(int i = 2; i < grid.length-2; i++){
                for(int j = 2; j < grid.length-2; j++){
                    if(counter >= buildings.size()){
                        break;
                    }
                    if(rng.nextFloat() < 0.1){
                        grid[i][j].setBuilding(buildings.get(counter));
                        buildings.get(counter).setStartingPosition(grid[i][j]);
                        counter++;
                    }
                }
            }
        } while(counter < buildings.size());
    }
    
    public void clearBoard(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                grid[i][j].setAttackHereListener(null);
                grid[i][j].setMoveHereListener(null);
                grid[i][j].redrawIcons();
            }
        }
    }
    
    public void highlightAffectedTiles(Unit u, String purpose){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                grid[i][j].setAttackHereListener(null);
                grid[i][j].setMoveHereListener(null);
                if(purpose.equals("Attack")){
                    grid[i][j].setAttackHereListener(u);
                }
                else if (purpose.equals("Move")){
                    grid[i][j].setMoveHereListener(u);
                }
            }
        }
    }
    public void highlightStartingPositions(Army army){
        
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
            the_gui.updateGUI_selectedTile((GridSquare) e.getSource());
        }
    }
}
