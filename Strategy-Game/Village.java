/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import java.lang.Cloneable;
/**
 *
 * @author Jack and Duran
 */
public class Village extends Building implements Cloneable{
    
    private static final int HP_RECOVERY = 10;
    private static final int ATTACK_BOOST = 0;
    private static final int DEFENSE_BOOST = 0;
    
    private static final ObjectIcon VILLAGE_ICON = new ObjectIcon();
    
    public Village(){
        super(VILLAGE_ICON, ATTACK_BOOST, DEFENSE_BOOST, HP_RECOVERY);
    }
}
