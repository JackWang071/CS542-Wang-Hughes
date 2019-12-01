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
public class Fort extends Building implements Cloneable{
    
    private static final int HP_RECOVERY = 0;
    private static final int ATTACK_BOOST = 0;
    private static final int DEFENSE_BOOST = 5;
    private static final String BUILDING_NAME = "Fort";
    
    private static final ObjectIcon FORT_ICON = new ObjectIcon("F");
    
    public Fort(){
        super(BUILDING_NAME, FORT_ICON, ATTACK_BOOST, DEFENSE_BOOST, HP_RECOVERY);
    }
}
