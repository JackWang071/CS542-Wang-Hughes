package cs542_project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jack
 */
public interface GameManager_IF {
    public void showLegalAttacks(Unit u);
    public void showLegalMoves(Unit u);
    public void doNothing(Unit u);
    public void showUnits(Army army);
}
