/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a10;

/**
 *
 * @author Jack
 */
public interface Hazard_Report_IF {
    
    void seeDanger(Hazard h);
    
    void setDirectOverseer(Hazard_Report_IF r);
    
    void evacuate();
    
    Hazard_Report_IF getDirectOverseer();
}
