/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a8;
import java.util.ArrayList;
/**
 *
 * @author Jack and Duran
 */
public class LineOfText extends CompositeArchiveElement {
    
    
    public LineOfText(String characters){
        for(int i = 0; i < characters.length(); i++){
            add(new Character(characters.charAt(i), 12, "Times New Roman"));
        }
    }
    
    
}
