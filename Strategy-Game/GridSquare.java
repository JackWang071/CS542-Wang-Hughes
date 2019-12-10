package cs542_project;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 *
 * @author Jack and Duran
 */
public class GridSquare extends JButton{
    
    //variables
    private int[] position;
    private Unit occupier;
    private Building building;
    private GameBoard the_board;
    private MoveHereListener move_here;
    private AttackHereListener attack_here;
    private TileSelectListener select_here;
    
    private int tile_edge;
    
    //constructor
    public GridSquare(int[] position, GameBoard the_board){
        this.position = position;
        this.the_board = the_board;
        move_here = new MoveHereListener();
        attack_here = new AttackHereListener();
        select_here = new TileSelectListener();
        setRolloverEnabled(true);
        
        tile_edge = 0;
    }
    
    //returns int array containing x,y
    public int[] getCoordinates(){
        return position;
    }
    
    //sets size of tile
    public void setTileEdge(int edge_length){
        tile_edge = edge_length;
    }
    
    //adds listeners
    public void activateListeners(){
        addActionListener(move_here);
        addActionListener(attack_here);
        addActionListener(select_here);
    }
    
    //updates tile with appropriately sized art reflecting current units occupying it
    public void redrawIcons(){
        if(building != null){
            setIcon(building.getObjectIcon().returnIcon(tile_edge));
            if(occupier != null){
                setRolloverIcon(occupier.getObjectIcon().returnIcon(tile_edge));
            }
        }
        else if(occupier != null){
            setIcon(occupier.getObjectIcon().returnIcon(tile_edge));
        }
        else{
            setIcon(null);
            setRolloverIcon(null);
        }
        
        if(occupier != null){
            setBackground(occupier.getArmy().getArmyColor());
        }
        else{
            setBackground(null);
        }
    }
    
    //gets unit on tile
    public Unit getOccupier(){
        return occupier;
    }
    
    //gets building on tile
    public Building getBuilding(){
        return building;
    }
    
    //sets which unit is on tile and updates art to reflect change
    public void setOccupier(Unit occ){
        occupier = occ;
        redrawIcons();
    }
    
    //sets which building is on tile and updates art to reflect change
    public void setBuilding(Building build){
        building = build;
        redrawIcons();
    }
    
    //move listener
    public void setMoveHereListener(Unit actor){
        if(actor == null){
            move_here.setActor(null);
            redrawIcons();
            return;
        }
        
        int actor_moveDist = actor.getMoveDist();
        int[] actor_pos = actor.getPosition().getCoordinates();
        int distance = Math.abs(actor_pos[0] - position[0]) + Math.abs(actor_pos[1] - position[1]);
        if(getOccupier() == null && distance > 0 && distance <= actor_moveDist){
            move_here.setActor(actor);
            setBackground(Color.BLUE);
        }
        else{
            move_here.setActor(null);
            redrawIcons();
        }
    }
    
    //attack listener
    public void setAttackHereListener(Unit actor){
        if(actor == null){
            attack_here.setActor(null);
            redrawIcons();
            return;
        }
        int actor_range = actor.getRange();
        int[] actor_pos = actor.getPosition().getCoordinates();
        int distance = Math.abs(actor_pos[0] - position[0]) + Math.abs(actor_pos[1] - position[1]);
        if(distance > 0 && distance <= actor_range){
            setBackground(Color.MAGENTA);
            if(getOccupier() != null){
                attack_here.setActor(actor);
                if(getOccupier().getArmy().equals(actor.getArmy())){
                    setBackground(getOccupier().getArmy().getArmyColor());
                }
            }
        }
        else{
            attack_here.setActor(null);
            redrawIcons();
        }
    }
    
    //updates tiles current status
    private void updateTileStatus(){
        the_board.clearBoard();
        the_board.getGUI().updateGUI_selectedTile(this);
    }
    
    /**
     * TODO: allow the actor's previous position to redraw itself minus the actor
     */
    private class MoveHereListener implements ActionListener{
        private Unit actor;
        public void setActor(Unit actor){
            this.actor = actor;
        }
        public boolean hasActor(){
            return (actor != null);
        }
        public void actionPerformed(ActionEvent e){
            if(actor != null){
                actor.move(GridSquare.this);
                setActor(null);
                updateTileStatus();
            }
        }
    }
    
    private class AttackHereListener implements ActionListener{
        private Unit actor;
        public void setActor(Unit actor){
            this.actor = actor;
        }
        public boolean hasActor(){
            return (actor != null);
        }
        public void actionPerformed(ActionEvent e){
            if(actor != null){
                actor.attack(getOccupier());
                setActor(null);
                if(getOccupier().is_destroyed()){
                    setOccupier(null);
                }
                updateTileStatus();
            }
        }
    }
    
    private class TileSelectListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(!attack_here.hasActor() && !move_here.hasActor()){
                updateTileStatus();
            }
        }
    }
}
