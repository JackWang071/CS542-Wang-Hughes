/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a8;
import java.util.HashMap;

/**
 *
 * @author Jack and Duran
 */
public class Archive {
    
    private static Archive archive_inst;
    private HashMap<String, Novel> list_of_novels;
    
    private Archive(){
        list_of_novels = new HashMap<>();
    }
    
    public static Archive getArchive(){
        if(archive_inst == null){
            archive_inst = new Archive();
        }
        return archive_inst;
    }
    
    
    
}
