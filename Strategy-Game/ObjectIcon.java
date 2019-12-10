package cs542_project;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Image;

/**
 *
 * @author Jack and Duran
 */
public class ObjectIcon extends ImageIcon{
    
    //variables
    private BufferedImage the_image;
    private int img_width;
    private int img_height;
    
    //constructor
    public ObjectIcon(String link){
        try{
            the_image = ImageIO.read(new File(link));
            setImage(the_image);
            img_width = the_image.getWidth();
            img_height = the_image.getHeight();
        }
        catch(IOException ioe){
            the_image = null;
            img_width = 0;
            img_height = 0;
        }
    }
    
    //retrives image icon at correct scale
    public ImageIcon returnIcon(double length){
        if (the_image != null && Math.max(img_width, img_height) >= length){
            double scale_ratio = length/ (double) Math.max(img_width, img_height);
            int new_img_width = (int) (img_width * scale_ratio);
            int new_img_height = (int) (img_height * scale_ratio);
            setImage(the_image.getScaledInstance(new_img_width, new_img_height, java.awt.Image.SCALE_SMOOTH));
        }
        return this;
    }
}
