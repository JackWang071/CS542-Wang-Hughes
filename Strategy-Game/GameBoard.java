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
import java.util.List;
import java.util.Random;
/**
 *
 * @author Jack and Duran
 */
public class GameBoard extends JPanel {
    private GridSquare[][] grid;
    private GameGUI the_gui;
    private static final int PLACEMENT_MARGIN = 2;
    
    public GameBoard(GameGUI the_gui){
        this.the_gui = the_gui;
        this.setPreferredSize(new Dimension(700, 700));
    }
    
    public void createBoard(int size){
        setLayout(new GridLayout(size, size));
        grid = new GridSquare[size][size];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = new GridSquare(new int[]{i, j}, this);
                this.add(grid[i][j]);
            }
        }
    }
    
    public GameGUI getGUI(){
        return the_gui;
    }
    
    public void activateBoard(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j].activateListeners();
            }
        }
    }
    
    public void addBuildings(List<Building> buildings){
        int counter = 0;
        Random rng = new Random();
        do{
            for(int i = PLACEMENT_MARGIN; i < grid.length-PLACEMENT_MARGIN; i++){
                for(int j = PLACEMENT_MARGIN; j < grid.length-PLACEMENT_MARGIN; j++){
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
            top = PLACEMENT_MARGIN;
            bottom = grid.length - PLACEMENT_MARGIN;
            left = 0;
            right = PLACEMENT_MARGIN;
        }
        else if(army.getArmyColor() == Color.YELLOW){
            top = PLACEMENT_MARGIN;
            bottom = grid.length - PLACEMENT_MARGIN;
            left = grid.length - PLACEMENT_MARGIN;
            right = grid.length;
        }
        else if(army.getArmyColor() == Color.GREEN){
            top = 0;
            bottom = PLACEMENT_MARGIN;
            left = PLACEMENT_MARGIN;
            right = grid.length - PLACEMENT_MARGIN;
            
        }
        else if(army.getArmyColor() == Color.CYAN){
            top = grid.length - PLACEMENT_MARGIN;
            bottom = grid.length;
            left = PLACEMENT_MARGIN;
            right = grid.length - PLACEMENT_MARGIN;
        }
        
        int[] this_coordinate = new int[]{0, 0};
        for(int i = top; i < bottom; i++){
            for(int j = left; j < right; j++){
                this_coordinate[0] = i;
                this_coordinate[1] = j;
                if(grid[i][j].getOccupier() == null){
                    grid[i][j].setBackground(army.getArmyColor());
                    grid[i][j].addActionListener(new ArmySetupPanel.UnitPlacementListener());
                }
            }
        }
    }
    
    public void saveBoardDetails(SaveData save){
        save.saveBoardSize(grid.length);
        for(GridSquare[] row : grid){
            for(GridSquare gs : row){
                if(gs.getOccupier() != null){
                    save.saveUnit(gs.getOccupier());
                }
            }
        }
    }
    
    public void loadBoardDetails(SaveData save){
        List<Unit> units = save.getUnits();
        List<Building> buildings = save.getBuildings();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                for(Unit u : units){
                    if(u.getPosition().getCoordinates()[0] == i && u.getPosition().getCoordinates()[1] == j){
                        grid[i][j].setOccupier(u);
                        u.setStartingPosition(null);
                        u.setStartingPosition(grid[i][j]);
                        break;
                    }
                }
                for(Building b : buildings){
                    if(b.getPosition().getCoordinates()[0] == i && b.getPosition().getCoordinates()[1] == j){
                        grid[i][j].setBuilding(b);
                        b.setStartingPosition(null);
                        b.setStartingPosition(grid[i][j]);
                        break;
                    }
                }
            }
        }
    }
}
