
package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public abstract class Unit implements GameObject_IF {
    //variables
    private String unitName;
    private int attack;
    private int moveDist;
    private int defense;
    private int range;
    private int HP;
    private int maxHP;
    private GridSquare position;
    private int cost;
    private Army army;
    private ObjectIcon icon;
    
    private boolean can_move;
    private boolean can_attack;
    
    //constructor
    public Unit(String name, Army army, int hp, int attack, int move, int def, int range, int cost, ObjectIcon icon){
        this.unitName = name;
        this.army = army;
        this.HP = hp;
        this.maxHP = hp;
        this.attack = attack;
        this.defense = def;
        this.moveDist = move;
        this.range = range;
        this.cost = cost;
        this.icon = icon;
    }
    
    //clonable
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    //get unit's current position
    public GridSquare getPosition(){
        return position;
    }
    
    //spawn unit in valid location
    public void setStartingPosition(GridSquare startPos){
        if(position == null || startPos == null){
            position = startPos;
        }
    }
    
    //get unit icon
    public ObjectIcon getObjectIcon(){
        return icon;
    }
    
    //getter functions
    public Army getArmy(){
        return army;
    }
    public String getName(){
        return unitName;
    }
    public int getAttack(){
        int attack_modifier = 0;
        if(getPosition().getBuilding() != null){
            attack_modifier = getPosition().getBuilding().getAttackBoost();
        }
        return attack + army.getRace().getAttackBonus() + attack_modifier;
    }
    public int getDefense(){
        int def_modifier = 0;
        if(getPosition().getBuilding() != null){
            def_modifier = getPosition().getBuilding().getDefenseBoost();
        }
        return defense + army.getRace().getDefBonus() + def_modifier;
    }
    public int getRange(){
        return range + army.getRace().getRangeBonus();
    }
    public int getHP(){
        return HP;
    }
    public int getMoveDist(){
        return moveDist + army.getRace().getMoveBonus();
    }
    public int getCost(){
        return cost;
    }
    
    //function for moving unit and updating new position
    public void move(GridSquare new_position){
        if(can_move()){
            position.setOccupier(null);
            position.redrawIcons();
            position = new_position;
            position.setOccupier(this);
            position.redrawIcons();
        }
        finished_moving();
    }
    
    //function for attacking enemy unit
    public void attack(Unit target){
        if(can_attack()){
            target.changeHP(-(getAttack()));
        }
        finished_attacking();
    }
    
    //update unit's current HP
    protected int changeHP(int amt){
        if (amt < 0){
            //Scratch damage (units must take 1dmg minimum when attacked)
            if(getDefense() >= -(amt)){
                HP -= 1;
            }
            else{
                HP += (amt + getDefense());
            }
        }
        else{
            HP += amt;
            if(HP > maxHP){
                HP = maxHP;
            }
        }
        return HP;
    }
    
    //update unit's status
    public void updateStatus(){
        if(!is_destroyed()){
            can_move = true;
            can_attack = true;
            //if unit is in a building apply building's healing bonus to unit's HP
            if(getPosition().getBuilding() != null){
                changeHP(getPosition().getBuilding().getHPRecovery());
            }
        }
    }
    
    //protected functions
    protected void finished_attacking(){
        can_attack = false;
    }
    protected void finished_moving(){
        can_move = false;
    }
    public boolean can_attack(){
        return can_attack;
    }
    public boolean can_move(){
        return can_move;
    }
    
    public boolean is_destroyed(){
        return (HP <= 0);
    }
    
    //formats unit's current stats
    public String toString(){
        return getArmy().getName()
                + "\n " + army.getRace().getRaceName() + " " + getName() 
                + "\n HP: " + getHP() + "/" + maxHP
                + "\n Attack: " + getAttack()
                + "\n Defense: " + getDefense()
                + "\n Movement: " + getMoveDist()
                + "\n Range: " + getRange()
                + "\n";
    }
}
