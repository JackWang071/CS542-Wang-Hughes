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
public abstract class Condiment {
    
    private float price;
    private String name;
    
    public Condiment(String name, float price){
        this.price = price;
        this.name = name;
    }
    
    public float getPrice(){
        return price;
    }
    
    public String getName(){
        return name;
    }
}
