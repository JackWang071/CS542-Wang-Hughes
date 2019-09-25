/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a4;
import java.util.List;
import java.text.DecimalFormat;
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
        DecimalFormat sigfig = new DecimalFormat("#.00");
        List<Product> sorted_list = s_util.sort(items, sortingApproach);
        //If quicksort
        if(sortingApproach == 0){
            for(int i = 0; i < sorted_list.size(); i++){
                System.out.print(i + ": ");
                System.out.println(sorted_list.get(i).getName() 
                        + " | " + sorted_list.get(i).getID() 
                        + " | $" + sigfig.format(sorted_list.get(i).getPrice()));
            }
        }
        //Else bubblesort
        else{
            for(int i = 0; i < sorted_list.size(); i++){
                System.out.print(i + ": ");
                System.out.println(sorted_list.get(i).getID() 
                        + " | " + sorted_list.get(i).getName() 
                        + " | $" + sigfig.format(sorted_list.get(i).getPrice()));
            }
        }
        return sorted_list;
    }
}
