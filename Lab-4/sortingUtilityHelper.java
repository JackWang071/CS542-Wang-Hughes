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
public class sortingUtilityHelper {
    
    sortingUtility s_util;
    
    public sortingUtilityHelper(){
        s_util = new sortingUtility();
    }
    
    public List<Product> sort(List<Product> items, int sortingApproach){
        List<Product> sorted_list = s_util.sort(items, sortingApproach);
        //If quicksort
        if(sortingApproach == 0){
            for(int i = 0; i < sorted_list.size(); i++){
                
            }
        }
        //Else bubblesort
        else{
            for(int i = 0; i < sorted_list.size(); i++){
                
            }
        }
        return sorted_list;
    }
}
