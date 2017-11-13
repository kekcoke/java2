package ca.bcit.comp2526.a2a;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * Specific entity describing an empty cell.
 * Created for the purpose of easier
 * debugging for NullPointerExceptions.
 * @author kekcoke
 * @version 2.0.
 * 
 */
public class Nil extends Entity {
    
    /**
     * Generated sVUID.
     */
    private static final long serialVersionUID = -4081784389887561779L;
    
    private Cell cell;

    /**
     * Creates a NIL object,
     * exclusively for an Empty cell.
     * @param cell
     *            cell.
     */
    public Nil(Cell cell) {
        super(cell, EntityID.NIL, Color.GRAY, new JLabel("N"));
        this.cell = cell;
        init();
    }
    
    /**
     * Sets green background.
     */
    public void init() {
    	cell.add(new JLabel("n"));
    	cell.setBackground(Color.GRAY);
    }
}
