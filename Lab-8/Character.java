package cs542_a8;

/**
 *
 * @author Jack and Duran
 */
public class Character implements ArchiveElementIF {
    
    private String font;
    private int size;
    private char unicode;
    
    public Character(char unicode, int size, String font){
        this.unicode = unicode;
        this.size = size;
        this.font = font;
    }
    
    public void display(){
        System.out.print(unicode);
    }
}
