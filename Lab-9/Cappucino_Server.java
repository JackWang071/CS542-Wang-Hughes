/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a9;

/**
 *
 * @author Jack and Duran
 */
public class Cappucino_Server implements CMM_LoadableServer_IF {
    private CMM_OpenAPI_IF env;
    
    public void setEnvironment(CMM_OpenAPI_IF env){
        this.env = env;
    }
    public void start(){
        
    }
}
