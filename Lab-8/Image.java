/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a8;

/**
 *
 * @author Jack and Duran
 */
public class Image implements ArchiveElementIF {
    
    String name;
    int width;
    int height;
    
    public Image(String n, int w, int h){
        name = n;
        width = w;
        height = h;
    }
    
    public void display() {
        System.out.print(name);
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
