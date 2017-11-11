package ca.bcit.comp2526.a2a;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Superclass hosting Herbivore, Plant,
 * and other subsequent living/non-organisms.
 * @author Kevin Oane
 * @version 1.0.
 */
abstract class Entity extends JPanel {
    /**
     * Generated serialVersionUID.
     */
    private static final long serialVersionUID = -1924283204073300101L;
    
    private Cell cell;    
    
    private EntityID entID;
    
    private JLabel jeSuis;
    
    private Color color;
    
    
 /**
  * Constructor.
  * @param cell
  *            Cell instance in World.
  * @param id
  *            Designated enumID classification.
  * @param ofEnt
  *            Designated entity color.
  */
    Entity(Cell cell, EntityID id, Color color, JLabel sym) {
        this.cell = cell;
        entID = id; 
        this.color = color;
        jeSuis = sym;
    }
    
    /**
     * Initializes background color.
     */
    public void init() {
        cell.setBackground(color);
        cell.add(jeSuis);
    }
    
    /**
     * Updates entity coordinates to cell coordinates.
     * @param cell
     *             cell parameter.
     *                        
     */
    public void setCell(final Cell cell) {
        this.cell = cell;
    }
    
    /**
     * Gets cellEntity.
     * @return cellEntity.
     *                     This cell.
     */
    public Cell getCell() {
        return cell;
    }
    
    /**
     * Returns enum type of entity.
     * @return
     *        entID, an enum type.
     */
    public EntityID getEntityID() {
        return entID;
    }
    
    public JLabel getLabel() {
    	return jeSuis;
    }
    
    public void setLabel(JLabel color) {
    	jeSuis = color;
    }
    

}
