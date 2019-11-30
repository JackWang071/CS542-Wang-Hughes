/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542_project;

import java.awt.Color;

/**
 *
 * @author Jack and Duran
 */
public class Cs542_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //GameManager test = new GameManager();
        
        
        GameGUI tester = new GameGUI(null);
        tester.showBoard(12);
        tester.setVisible(true);
        
        tester.getBoard().highlightLegalStartingPositions(Color.RED);
        tester.getBoard().highlightLegalStartingPositions(Color.YELLOW);
        tester.getBoard().highlightLegalStartingPositions(Color.GREEN);
        tester.getBoard().highlightLegalStartingPositions(Color.BLUE);
    }
    
}
