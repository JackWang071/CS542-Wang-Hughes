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
    
    private int height;
    private int width;
    private String name;
    
    public Image(String name, int height, int width){
        this.height = height;
        this.width = width;
        this.name = name;
    }
    
    public void display(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
