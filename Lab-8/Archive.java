/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_a8;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;

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
    
    public boolean addNovel(String isbn, Novel novel){
        try{
            list_of_novels.put(isbn, novel);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public Novel getNovel(String isbn){
        return list_of_novels.get(isbn);
    }
    
    public void showAll(){
        Collection all_novels = list_of_novels.values();
        Iterator novels_iter = all_novels.iterator();
        
        while(novels_iter.hasNext()){
            Novel n = (Novel) novels_iter.next();
            
        }
    }
}
