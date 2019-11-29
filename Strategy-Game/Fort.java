/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

/**
 *
 * @author Jack
 */
public class Fort extends Building{
    
    private static final int HP_RECOVERY = 0;
    private static final int ATTACK_BOOST = 5;
    private static final int DEFENSE_BOOST = 5;
    
    public Fort(){
        super(ATTACK_BOOST, DEFENSE_BOOST, HP_RECOVERY);
    }
    
    public int[] setStartingPosition(){
        return null;
    }
}
