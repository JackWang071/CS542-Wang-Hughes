/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a4;

/**
 *
 * @author Jack
 */
public class Product {
    private int ID;
    private String name;
    private double price;
    
    public Product(int ID, String name, double price){
        this.ID = ID;
        this.name = name;
        this.price = price;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public void setPrice(double p){
        this.price = p;
    }
}