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
    
    private JButton choose_elf;
    private JButton choose_dwarf;
    private JButton choose_orc;
    
    private JButton choose_infantry;
    private JButton choose_cavalry;
    private JButton choose_archers;
    
    
    private TextField remaining_points;
    private TextField current_army_name;
    
    private JButton finish_setup;
    
    private Army current_army;
    private Unit_Factory current_unit_factory;
    
    public ArmySetupPanel(GameGUI the_gui){
        this.setPreferredSize(new Dimension(400, 700));
        this.the_gui = the_gui;
        
        choose_elf = new JButton("Elves - Faster");
        choose_dwarf = new JButton("Dwarves - Tougher");
        choose_orc = new JButton("Orcs - Stronger");
        choose_elf.setPreferredSize(new Dimension(200, 50));
        choose_dwarf.setPreferredSize(new Dimension(200, 50));
        choose_orc.setPreferredSize(new Dimension(200, 50));
        
        choose_infantry = new JButton("Infantry - cost " + Infantry.getUnitCost());
        choose_cavalry = new JButton("Cavalry - cost " + Cavalry.getUnitCost());
        choose_archers = new JButton("Archers - cost " + Archers.getUnitCost());
        choose_infantry.setPreferredSize(new Dimension(200, 50));
        choose_cavalry.setPreferredSize(new Dimension(200, 50));
        choose_archers.setPreferredSize(new Dimension(200, 50));
        
        remaining_points = new TextField();
        current_army_name = new TextField();
        
        finish_setup = new JButton("Finish");
        finish_setup.setPreferredSize(new Dimension(100, 50));
    }
    
    public void startArmySetup(){

        current_army = the_gui.getManager().cycleThroughArmies(1);
        current_unit_factory = current_army.createUnitFactory();
        
        this.add(current_army_name);
        current_army_name.setText(current_army.getName());
        
        choose_elf.addActionListener(new RacePickListener(Elf_Race.getElfArchetype()));
        choose_dwarf.addActionListener(new RacePickListener(Dwarf_Race.getDwarfArchetype()));
        choose_orc.addActionListener(new RacePickListener(Orc_Race.getOrcArchetype()));
        
        this.add(choose_elf);
        this.add(choose_dwarf);
        this.add(choose_orc);
        
        choose_infantry.addActionListener(new UnitPickListener("Infantry"));
        choose_cavalry.addActionListener(new UnitPickListener("Cavalry"));
        choose_archers.addActionListener(new UnitPickListener("Archers"));
        
        this.add(remaining_points);
        remaining_points.setText(current_army.getPointsLeft() + " points left");
        
        this.add(choose_infantry);
        this.add(choose_cavalry);
        this.add(choose_archers);
        
        finish_setup.addActionListener(new FinishArmySetupListener());
        this.add(finish_setup);
        
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
            try{
                current_army.addUnit(current_unit_factory.createUnit(unit_type));
                //int points_left = the_gui.getManager().getArmies().get(the_gui.getManager().getArmies().size() - 1).getPointsLeft();
                remaining_points.setText(current_army.getPointsLeft() + " points left");
            }
            catch(CloneNotSupportedException cnse){
                
            }
        }
    }
    
    public class FinishArmySetupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            current_army = the_gui.getManager().cycleThroughArmies(1);
            if(current_army != null){
                current_unit_factory = current_army.createUnitFactory();
                current_army_name.setText(current_army.getName());
                remaining_points.setText(current_army.getPointsLeft() + " points left");
            }
            else{
                the_gui.showReadyGame();
            }
        }
    }
}
