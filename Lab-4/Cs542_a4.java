/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a4;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Jack
 */
public class Cs542_a4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Product> sort_this = new ArrayList();
        String already_used = "";
        Random rng = new Random();
        for(int i = 0; i <= 10; i++){
            int id; 
            do{
                id = rng.nextInt(100);
            } while(already_used.indexOf(id) != -1);
            already_used = already_used + id + ',';
            
            String name = randword();
            double price = rng.nextDouble()*100;
            sort_this.add(new Product(id, name, price));
        }
        
        for(int i = 0; i < sort_this.size(); i++){
            System.out.print(i + ": ");
            System.out.println(sort_this.get(i).getID());
        }
        
    }
    public static String randword(){
        Random rng = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int length = 0;
        while(length < 5){
            length = rng.nextInt(20);
        }
        String the_word = "";
        for(int i = 0; i < length; i++){
            the_word = the_word + letters.charAt(rng.nextInt(26));
        }
        return the_word;
    }
}

