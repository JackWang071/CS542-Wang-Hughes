/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.TextField;
import java.util.ListIterator;
/**
 *
 * @author Jack and Duran
 */
public class ArmySetupPanel extends JPanel{
    private GameGUI the_gui;
    
    private JPanel race_panel;
    private JPanel unit_panel;
    
    private TextField remaining_points;
    private TextField current_army_name;
    
    private JButton finish_setup;
    
    private Army current_army;
    private Unit_Factory current_unit_factory;
    
    public ArmySetupPanel(GameGUI the_gui){
        this.setPreferredSize(new Dimension(400, 700));
        this.the_gui = the_gui;
        
        race_panel = new JPanel();
        
        JButton choose_elf = new JButton("Elves - Faster");
        JButton choose_dwarf = new JButton("Dwarves - Tougher");
        JButton choose_orc = new JButton("Orcs - Stronger");
        choose_elf.setPreferredSize(new Dimension(200, 50));
        choose_dwarf.setPreferredSize(new Dimension(200, 50));
        choose_orc.setPreferredSize(new Dimension(200, 50));
        choose_elf.addActionListener(new RacePickListener(Elf_Race.getElfArchetype()));
        choose_dwarf.addActionListener(new RacePickListener(Dwarf_Race.getDwarfArchetype()));
        choose_orc.addActionListener(new RacePickListener(Orc_Race.getOrcArchetype()));
        race_panel.add(choose_elf);
        race_panel.add(choose_dwarf);
        race_panel.add(choose_orc);
        
        unit_panel = new JPanel();
        
        JButton choose_infantry = new JButton("Infantry - cost " + Infantry.getUnitCost());
        JButton choose_cavalry = new JButton("Cavalry - cost " + Cavalry.getUnitCost());
        JButton choose_archers = new JButton("Archers - cost " + Archers.getUnitCost());
        choose_infantry.setPreferredSize(new Dimension(200, 50));
        choose_cavalry.setPreferredSize(new Dimension(200, 50));
        choose_archers.setPreferredSize(new Dimension(200, 50));
        choose_infantry.addActionListener(new UnitPickListener("Infantry"));
        choose_cavalry.addActionListener(new UnitPickListener("Cavalry"));
        choose_archers.addActionListener(new UnitPickListener("Archers"));
        unit_panel.add(choose_infantry);
        unit_panel.add(choose_cavalry);
        unit_panel.add(choose_archers);
        
        remaining_points = new TextField();
        current_army_name = new TextField();
        
        finish_setup = new JButton("Finish");
        finish_setup.setPreferredSize(new Dimension(100, 50));
        finish_setup.addActionListener(new FinishArmySetupListener());
    }
    
    public void startArmySetup(){
        changeArmy();
        this.add(current_army_name);
        this.add(race_panel);
        this.add(unit_panel);
        this.add(remaining_points);
        
        this.add(finish_setup);
        
    }
    
    private void changeArmy(){
        current_army = the_gui.getManager().cycleThroughArmies(1);
        if(current_army != null){
            current_unit_factory = current_army.createUnitFactory();
            current_army_name.setText(current_army.getName());
            remaining_points.setText(current_army.getPointsLeft() + " points left");
            the_gui.getBoard().highlightLegalStartingPositions(current_army.getArmyColor());
        }
        else{
            the_gui.showReadyGame();
        }
    }
    
    public class RacePickListener implements ActionListener{
        private Race army_race;
        
        public RacePickListener(Race army_race){
            this.army_race = army_race;
        }
        public void actionPerformed(ActionEvent e){
            current_army.setRace(army_race);
        }
    }
    
    public class UnitPickListener implements ActionListener{
        private String unit_type;
        public UnitPickListener(String unit_type){
            this.unit_type = unit_type;
        }
        
        public void actionPerformed(ActionEvent e){
            if(UnitPlacementListener.getCurrentUnit() != null){
                return;
            }
            try{
                Unit new_unit = current_unit_factory.createUnit(unit_type);
                current_army.addUnit(new_unit);
                UnitPlacementListener.setCurrentUnit(new_unit);
                remaining_points.setText(current_army.getPointsLeft() + " points left");
            }
            catch(CloneNotSupportedException cnse){
                
            }
        }
    }
    
    public class FinishArmySetupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(current_army.getRace() == null){
                return;
            }
            changeArmy();
        }
    }
    
    public static class UnitPlacementListener implements ActionListener{
        private static Unit current_unit;
        public static void setCurrentUnit(Unit u){
            current_unit = u;
        }
        public static Unit getCurrentUnit(){
            return current_unit;
        }
        public void actionPerformed(ActionEvent e){
            if(current_unit != null){
                GridSquare this_tile = (GridSquare) e.getSource();
                current_unit.setStartingPosition(this_tile.getPosition());
                this_tile.setOccupier(current_unit);
                this_tile.redrawIcons();
                setCurrentUnit(null);

                for(ActionListener act : this_tile.getActionListeners()) {
                    this_tile.removeActionListener(act);
                }
            }
        }
    }
}
