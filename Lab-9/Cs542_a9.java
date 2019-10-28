/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a9;

/**
 *
 * @author Jack
 */
public class Cs542_a9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CMM_LoadableServer_IF regular = new Regular_Server();
        CMM_LoadableServer_IF mocha = new Mocha_Server();
        CMM_LoadableServer_IF latte = new Latte_Server();
        CMM_LoadableServer_IF espresso = new Espresso_Server();
        CMM_LoadableServer_IF cappucino = new Cappucino_Server();
        
        CMM_OS operating_system = new CMM_OS();
        
        operating_system.setServer(regular);
        operating_system.run();
        
        operating_system.setServer(mocha);
        operating_system.run();
        
    }
    
}
