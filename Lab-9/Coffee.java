/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a9;
import java.util.ArrayList;

/**
 *
 * @author Jack and Duran
 */
public abstract class Coffee {
    
    private String name;
    private float price;
    private ArrayList<Condiment> condiments;
    
    public Coffee(String name, float price){
        this.name = name;
        this.price = price;
        condiments = new ArrayList();
    }
    
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public float getTotalPrice(){
        float total_price = price;
        for(Condiment c : condiments){
            total_price += c.getPrice();
        }
        return total_price;
    }
    public void addCondiment(Condiment cond){
        condiments.add(cond);
    }
    public void removeCondiment(Condiment cond){
        condiments.remove(cond);
    }
}
