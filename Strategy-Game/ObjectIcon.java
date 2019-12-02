/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Jack and Duran
 */
public class ObjectIcon {
    
    private String link;
    private ImageIcon the_icon;
    
    private static ObjectIcon EMPTY_ICON = new ObjectIcon("");
    
    public ObjectIcon(String link){
        this.link = link;
        try{
            the_icon = new ImageIcon(ImageIO.read(new File(link)));
        }
        catch(IOException ioe){
            the_icon = new ImageIcon();
        }
    }
    
    public String drawThis(){
        return link;
    }
    
    public static ObjectIcon getEmptyIcon(){
        return EMPTY_ICON;
    }
}
