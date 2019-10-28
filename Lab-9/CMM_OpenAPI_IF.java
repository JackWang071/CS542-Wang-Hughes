package cs542_a9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jack and Duran
 */
public interface CMM_OpenAPI_IF {
    public void setCoffeeType(String str);
    public void setGrindingTime(int secs);
    public void addCondiment(CondimentIF type);
    public void setTemperature(int degree);
    public boolean holdTemperature(int seconds);
    public void setPowerLED(int num);
    public void setTypeLED(int num);
    public void computePrice(CoffeeIF cif);
    public void done();
}
