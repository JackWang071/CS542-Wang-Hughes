package cs542_project;
/**
 *
 * @author Jack
 */
public abstract class Building implements GameObject_IF {
    //variables
    private int attack_boost;
    private int defense_boost;
    private int hp_recovery;
    private GridSquare position;
    private ObjectIcon icon;
    private String name;
    
    //constructor
    public Building(String name, ObjectIcon icon, int attack, int defense, int hp_rec){
        this.attack_boost = attack;
        this.defense_boost = defense;
        this.hp_recovery = hp_rec;
        this.icon = icon;
        this.name = name;
    }
    
    //make cloneable
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    //getters
    public String getName(){
        return name;
    }
    
    public GridSquare getPosition(){
        return position;
    }
    public void setStartingPosition(GridSquare startPos){
        if(position == null){
            position = startPos;
        }
    }
    public ObjectIcon getObjectIcon(){
        return icon;
    }
    
    public int getAttackBoost(){
        return attack_boost;
    }
    
    public int getDefenseBoost(){
        return defense_boost;
    }
    
    public int getHPRecovery(){
        return hp_recovery;
    }
    
    //output formatting
    public String toString(){
        return getName() 
                + "\n Defense: +" + getDefenseBoost()
                + "\n HP: +" + getHPRecovery() + " per turn"
                + "\n";
    }
}
