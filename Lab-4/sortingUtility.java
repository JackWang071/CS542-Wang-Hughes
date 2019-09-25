/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a4;
import java.util.List;

/**
 *
 * @author Jack
 */
public class sortingUtility {
    
    public sortingUtility() { }
    
    public List<Product> sort(List<Product> items, int sortingApproach){
        if(sortingApproach == 0){
            return quicksort(items);
        }
        else {
            return bubblesort(items);
        }
    }
    
    private List<Product> quicksort(List<Product> items){
        //Pivoting
        int pivot = items.size()-1;
        int j = -1;
        for(int i = 0; i < items.size()-1; i++){
            if(items.get(pivot).getID() > items.get(i).getID()){
                j++;
                Product placeholder = items.get(i);
                items.set(i, items.get(j));
                items.set(j, placeholder);
            }
        }
        Product placeholder = items.get(pivot);
        items.set(pivot, items.get(j+1));
        items.set(j+1, placeholder);
        
        
        
        return items;
    }
    
    private List<Product> bubblesort(List<Product> items){
        int swaps;
        do{
            swaps = 0;
            for(int i = 0; i < items.size()-1; i++){
                if(items.get(i).getID() > items.get(i+1).getID()){
                    Product placeholder = items.get(i+1);
                    items.set(i+1, items.get(i));
                    items.set(i, placeholder);
                    swaps++;
                }
            }
        } while(swaps > 0);
        
        return items;
    }
}
