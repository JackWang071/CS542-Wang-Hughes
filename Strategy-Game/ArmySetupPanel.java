package cs542_project;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 *
 * @author Jack and Duran
 */
public class ArmySetupPanel extends JPanel{
    
    //variables
    private GameGUI the_gui;
    
    private JPanel race_panel;
    private JPanel unit_panel;
    
    private JLabel remaining_points;
    private JLabel current_army_name;
    
    private JButton finish_setup;
    
    private Army current_army;
    private Unit_Factory current_unit_factory;
    
    private Dimension default_button_size;
    
    //constructor
    public ArmySetupPanel(GameGUI the_gui){
        this.setPreferredSize(new Dimension(400, 700));
        this.the_gui = the_gui;
        default_button_size = new Dimension(200, 50);
        
        race_panel = new JPanel();
        race_panel.setPreferredSize(new Dimension(300, 200));
        JButton choose_elf = new JButton("Elves - Faster");
        JButton choose_dwarf = new JButton("Dwarves - Tougher");
        JButton choose_orc = new JButton("Orcs - Stronger");
        choose_elf.setPreferredSize(default_button_size);
        choose_dwarf.setPreferredSize(default_button_size);
        choose_orc.setPreferredSize(default_button_size);
        choose_elf.addActionListener(new RacePickListener(Elf_Race.getElfArchetype()));
        choose_dwarf.addActionListener(new RacePickListener(Dwarf_Race.getDwarfArchetype()));
        choose_orc.addActionListener(new RacePickListener(Orc_Race.getOrcArchetype()));
        race_panel.add(choose_elf);
        race_panel.add(choose_dwarf);
        race_panel.add(choose_orc);
        
        unit_panel = new JPanel();
        unit_panel.setPreferredSize(new Dimension(300, 270));

        remaining_points = new JLabel();
        remaining_points.setPreferredSize(new Dimension(300, 40));
        remaining_points.setHorizontalAlignment(SwingConstants.CENTER);
        
        current_army_name = new JLabel();
        current_army_name.setPreferredSize(new Dimension(300, 40));
        current_army_name.setHorizontalAlignment(SwingConstants.CENTER);
        
        finish_setup = new JButton("Finish");
        finish_setup.setPreferredSize(new Dimension(100, 50));
        finish_setup.addActionListener(new FinishArmySetupListener());
    }
    
    //initializes army setup
    public void startArmySetup(){
        this.add(current_army_name);
        this.add(race_panel);
        this.add(unit_panel);
        
        this.add(finish_setup);
        
        changeArmy();
    }
    
    //displays available units and cost
    private void updateUnitCatalog(){
        unit_panel.removeAll();
        unit_panel.add(remaining_points);
        Unit[] catalog = current_unit_factory.getUnitCatalog();
        for(Unit u : catalog){
            JButton new_button = new JButton(u.getName() + " - cost " + u.getCost());
            new_button.setPreferredSize(default_button_size);
            new_button.addActionListener(new UnitPickListener(u.getName()));
            unit_panel.add(new_button);
        }
    }
    
    //sets up current army
    private void changeArmy(){
        //Won't be visible until a race is selected.
        unit_panel.setVisible(false);
        current_army = the_gui.getManager().nextArmy();
        //If the current army's race is NULL, that means this army hasn't been set up yet.
        if(current_army.getRace() == null){
            current_unit_factory = current_army.createUnitFactory();
            updateUnitCatalog();
            current_army_name.setText(current_army.getName());
            remaining_points.setText(current_army.getPointsLeft() + " points left");
            the_gui.highlightStartingPositions(current_army);
            UnitPlacementListener.setCurrentUnit(null);
        }
        else{
            the_gui.showReadyGame();
        }
    }
    
    //race pick listener
    private class RacePickListener implements ActionListener{
        private Race army_race;
        
        public RacePickListener(Race army_race){
            this.army_race = army_race;
        }
        public void actionPerformed(ActionEvent e){
            current_army.setRace(army_race);
            unit_panel.setVisible(true);
            
            for(Component c : race_panel.getComponents()){
                c.setBackground(null);
                if(c.equals(e.getSource())){
                    c.setBackground(Color.CYAN);
                }
            }
        }
    }
    
    //unit pick listener
    private class UnitPickListener implements ActionListener{
        private String unit_type;
        public UnitPickListener(String unit_type){
            this.unit_type = unit_type;
        }
        
        public void actionPerformed(ActionEvent e){
            if(UnitPlacementListener.getCurrentUnit() != null){
                return;
            }
            Unit new_unit = current_unit_factory.createUnit(unit_type);
            current_army.addUnit(new_unit);
            UnitPlacementListener.setCurrentUnit(new_unit);
            remaining_points.setText(current_army.getPointsLeft() + " points left");
        }
    }
    
    //set up army listener
    private class FinishArmySetupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(current_army.getRace() == null){
                return;
            }
            else if(current_army.getNumActiveUnits() > 0){
                changeArmy();
                for(Component c : race_panel.getComponents()){
                    c.setBackground(null);
                }
            }
        }
    }
    
    //unit placement listener
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
                current_unit.setStartingPosition(this_tile);
                this_tile.setOccupier(current_unit);
                this_tile.redrawIcons();
                setCurrentUnit(null);

                for(ActionListener act : this_tile.getActionListeners()) {
                    if(act instanceof UnitPlacementListener){
                        this_tile.removeActionListener(act);
                    }
                }
            }
        }
    }
}
