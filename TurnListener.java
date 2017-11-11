package ca.bcit.comp2526.a2a;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Mouse-click dependent subtype action listener
 * that invokes a turn, effectively altering 
 * the World-GUI and its inhabitants.
 * 
 * @author Kevin Oane
 * @version 1. 
 *
 */
public class TurnListener extends MouseAdapter {
    private GameFrame gameframe;
    
    /**
     * Create a TurnListener listening
     * to a GameFrame object (GUI).
     * @param gameframe
     *                  Represents GameFrame hosting
     *                  the cells and its entities
     *                  in World.
     */
    public TurnListener(final GameFrame gameframe) {
        this.gameframe = gameframe;
    }
    
    /**
     * Calls takeTurn (at GameFrame in World) when mouse
     * is clicked.
     * @param e
     *           Signals a MouseEvent
     */
    
    public void mouseClicked(MouseEvent e) {
        System.out.println("CLICK");
        gameframe.takeTurn();
    }
}
