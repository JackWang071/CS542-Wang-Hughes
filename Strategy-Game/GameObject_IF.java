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
public interface GameObject_IF extends Cloneable{
    GridSquare getPosition();
    void setStartingPosition(GridSquare startPos);
    ObjectIcon getObjectIcon();
    String toString();
}
