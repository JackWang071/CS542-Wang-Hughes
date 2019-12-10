package cs542_project;

/**
 *
 * @author Jack and Duran
 */

//interface for GameObject
public interface GameObject_IF extends Cloneable{
    GridSquare getPosition();
    void setStartingPosition(GridSquare startPos);
    ObjectIcon getObjectIcon();
    String toString();
}
