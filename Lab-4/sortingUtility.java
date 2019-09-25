/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a4;
import java.util.List;
import java.util.*;

/**
 *
 * @author Jack
 */
public class sortingUtility {
    
    public sortingUtility() { }
    
    public List<Product> sort(List<Product> items, int sortingApproach){
        if(sortingApproach == 0){
            return quicksort(items, 0, items.size()-1);
        }
        else {
            return bubblesort(items);
        }
    }
    
    private List<Product> quicksort(List<Product> items, int begin, int end){
//        //Pivoting
//        int pivot = items.size()-1;
//        int j = -1;
//        for(int i = 0; i < items.size()-1; i++){
//            if(items.get(pivot).getID() > items.get(i).getID()){
//                j++;
//                Product placeholder = items.get(i);
//                items.set(i, items.get(j));
//                items.set(j, placeholder);
//            }
//        }
//        Product placeholder = items.get(pivot);
//        items.set(pivot, items.get(j+1));
//        items.set(j+1, placeholder);
        
        //Alexander's Implementation!
        if(begin < end) {
            int p = partition(items, begin, end);
            
            quicksort(items, begin, p-1);
            quicksort(items, p+1, end);
        }      
        
        return items;
    }
    
    private int partition(List<Product> items, int b, int e) {
        int p = items.get(e).getID();
        int i = b-1;
        
        for(int x = b; x < e; x++) {
            if(items.get(x).getID() < p) {
                i++;
                
                Product pH = items.get(i);
                //items.get(i).getID() = items.get(x).getID();
                Collections.swap(items, i, x);
                //items.get(x).getID() = t;
                items.set(x, pH);
                
            }
        }
        
        //int t = items.get(i+1).getID();
        Product pH = items.get(i+1);
        //items.get(i+1).getID() = items.get(e).getID();
        Collections.swap(items, i+1, e);
        //items.get(e).getID() = t;
        //items.get(e) = pH;
        items.set(e, pH);
        
        return i+1;
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