/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;

import java.util.Scanner;
/**
 *
 * @author Jack
 */
public class SaveData {
    /*
    GameManager: save current turn (army index)
                save all buildings + location
    Army: save all units + location + HP + can_move/can_attack
    GameGUI: save
    GameBoard: save board size
    */
    
    private String pathname;
    private int current_turn;
    private int board_size;
    private List<String[]> all_army_data;
    private List<String[]> all_building_data;
    private List<String[]> all_unit_data;
    
    private List<Unit> units;
    private List<Building> buildings;
    
    public SaveData(){
        this.pathname = "savefiles/save.txt";
        all_building_data = new ArrayList();
        all_unit_data = new ArrayList();
        all_army_data = new ArrayList();
        
        units = new ArrayList();
        buildings = new ArrayList();
    }

    /*
    Save game methods
    */
    
    public void saveCurrentTurn(int turn){
        this.current_turn = turn;
    }
    
    public void saveBoardSize(int size){
        this.board_size = size;
    }
    
    public void saveArmies(List<Army> armies){
        for(Army a : armies){
            String[] army_data = new String[]{a.getName(), a.getRace().getRaceName()};
            all_army_data.add(army_data);
        }
    }
    
    public void saveUnit(Unit u){
        //Ignore destroyed units.
        if(u.is_destroyed()){
            return;
        }
        String[] unit_data = new String[7];
        unit_data[0] = u.getArmy().getName();
        unit_data[1] = u.getName();
        unit_data[2] = "" + u.getHP();
        unit_data[3] = "" + u.getPosition().getCoordinates()[0];
        unit_data[4] = "" + u.getPosition().getCoordinates()[1];
        unit_data[5] = "" + u.can_attack();
        unit_data[6] = "" + u.can_move();
        all_unit_data.add(unit_data);
    }
    
    public void saveBuildings(List<Building> buildings){
        for(Building b : buildings){
            String[] building_data = new String[3];
            building_data[0] = b.getName();
            building_data[1] = "" + b.getPosition().getCoordinates()[0]; 
            building_data[2] = "" + b.getPosition().getCoordinates()[1];
            all_building_data.add(building_data);
        }
    }
    
    public void outputToFile(){
        FileWriter fw;
        try{
            fw = new FileWriter(pathname);
            
            fw.write(board_size + "\n");
            fw.write(current_turn + "\n");
            
            fw.write("A\n");
            for(String[] army_data : all_army_data){
                for(String datapoint : army_data){
                    fw.write(datapoint + ",");
                }
                fw.write("\n");
            }
            
            fw.write("B\n");
            for(String[] building_data : all_building_data){
                for(String datapoint : building_data){
                    fw.write(datapoint + ",");
                }
                fw.write("\n");
            }
            
            fw.write("U\n");
            for(String[] unit_data : all_unit_data){
                for(String datapoint : unit_data){
                    fw.write(datapoint + ",");
                }
                fw.write("\n");
            }
            fw.write("*");
            fw.close();
        }
        catch(IOException ioe){
            System.out.println("Could not save game.");
        }
    }
    
    /*
    Load game methods
    */
    
    public void loadFromFile(){
        BufferedReader br;
        Scanner scanner;
        try{
            br = new BufferedReader(new FileReader(pathname));
            board_size = Integer.parseInt(br.readLine());
            current_turn = Integer.parseInt(br.readLine());
            br.readLine();
            
            String nline = br.readLine();
            //Fragility is deliberate. Messing with the save file may wreck your save.
            //Reading data for armies.
            while(!nline.equals("B")){
                scanner = new Scanner(nline).useDelimiter("\\s*,\\s*");
                all_army_data.add(new String[]{scanner.next(), scanner.next()});
                nline = br.readLine();
            }
            nline = br.readLine();
            //Reading data for buildings.
            while(!nline.equals("U")){
                scanner = new Scanner(nline).useDelimiter("\\s*,\\s*");
                all_building_data.add(new String[]{scanner.next(), scanner.next(), scanner.next()});
                nline = br.readLine();
            }
            nline = br.readLine();
            //Reading data for units.
            while(!nline.equals("*")){
                scanner = new Scanner(nline).useDelimiter("\\s*,\\s*");
                all_unit_data.add(new String[]{scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next()});
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
    
    public int getCurrentTurn(){
        return current_turn;
    }
    
    public int getNumArmies(){
        return all_army_data.size();
    }
    
    public void getArmyRaces(List<Army> armies){
        Elf_Race elf = Elf_Race.getElfArchetype();
        Dwarf_Race dwarf = Dwarf_Race.getDwarfArchetype();
        Orc_Race orc = Orc_Race.getOrcArchetype();
        for(Army army : armies){
            for(String[] army_data : all_army_data){
                if(army.getName().equals(army_data[0])){
                    if(elf.getRaceName().equals(army_data[1])){
                        army.setRace(elf);
                    }
                    else if(dwarf.getRaceName().equals(army_data[1])){
                        army.setRace(dwarf);
                    }
                    else if(orc.getRaceName().equals(army_data[1])){
                        army.setRace(orc);
                    }
                }
            }
        }
    }
    
    public void loadUnits(List<Army> armies){
        for(Army army : armies){
            Unit_Factory factory = army.createUnitFactory();
            for(String[] unit_data : all_unit_data){
                if(army.getName().equals(unit_data[0])){
                    //Initially creates this Unit and sets its current position in the board.
                    //Cannot calculate current HP until all board details are set up.
                    Unit new_unit = factory.createUnit(unit_data[1]);
                    int[] coordinates = new int[]{Integer.parseInt(unit_data[3]), Integer.parseInt(unit_data[4])};
                    new_unit.setStartingPosition(new GridSquare(coordinates, null));
                    army.addUnit(new_unit);
                    units.add(new_unit);
                }
            }
        }
    }
    
    public int getBoardSize(){
        return board_size;
    }
    
    public void loadBuildings(){
        BuildingFactory factory = new BuildingFactory();
        for(String[] building_data : all_building_data){
            Building new_building = factory.createBuilding(building_data[0]);
            int[] coordinates = new int[]{Integer.parseInt(building_data[1]), Integer.parseInt(building_data[2])};
            new_building.setStartingPosition(new GridSquare(coordinates, null));
            buildings.add(new_building);
        }
    }
    
    public List<Unit> getUnits(){
        return units;
    }
    
    public List<Building> getBuildings(){
        return buildings;
    }
    
    public void loadUnitStatuses(){
        for(Unit u : units){
            for(String[] unit_data : all_unit_data){
                if(u.getArmy().getName().equals(unit_data[0]) && u.getPosition().getCoordinates()[0] == Integer.parseInt(unit_data[3]) && u.getPosition().getCoordinates()[1] == Integer.parseInt(unit_data[4])){
                    u.changeHP(-(u.getHP() + u.getDefense()));
                    u.changeHP(Integer.parseInt(unit_data[2]));
                    if(u.can_attack() != Boolean.parseBoolean(unit_data[5])){
                        u.finished_attacking();
                    }
                    if(u.can_move() != Boolean.parseBoolean(unit_data[6])){
                        u.finished_moving();
                    }
                }
            }
        }
    }
}
