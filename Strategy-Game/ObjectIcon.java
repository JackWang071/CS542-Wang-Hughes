/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

/**
 *
 * @author Jack and Duran
 */
public class ObjectIcon {
    
    private String link;
    
    private static ObjectIcon EMPTY_ICON = new ObjectIcon("");
    
    public ObjectIcon(String link){
        this.link = link;
    }
    
    public String drawThis(){
        return link;
    }
    
    public static ObjectIcon getEmptyIcon(){
        return EMPTY_ICON;
    }
}
