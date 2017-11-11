package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

/**
 * Creates a plant as an instance of cell-entity.
 * Non-movable but can reproduce by spreading 
 * itself to empty cell with 2 neighboring plants  and
 * cross-pollinate to at least 3 empty neighboring cells.
 * @author Kevin Oane
 * @version 1.0
 */
public class Plant extends Entity {
    /**
     * Minimum number of adjacent empty cells 
     * required for seeding.
     */
    private static final int SEED_MIN = 3;

    /**
     * Minimum number of adjacent plant cells
     * required for seeding.
     */
    private static final int PLANT_MIN = 2;

    /**
     * Generated serialVersionUID.
     */
    private static final long serialVersionUID = -1065942106883237644L;

    private Cell cell;

    /**
     * Creates Plant object.
     * @param cell
     *        cell.
     */
    public Plant(Cell cell) {
        super(cell, EntityID.PLANT, Color.GREEN, new JLabel("P"));
        this.cell = cell;
        init();
    }

    /**
     * Sets green background.
     */
    public void init() {
    	super.init();
    	/*cell.setBackground(Color.green);
    	cell.add(new JLabel("P"));*/
    }

    /**
     * Gets cell (plant).
     * @return
     *     Specified plant cell.
     */
    public Cell getCell() {
        return cell;
    }

    /**
     * Places cell into specified array position in Cell[][]
     * in world. Plant however will \seed." 
     * If a Plant is surrounded by at least 3 empty neighbouring
     * Cells and at least two neighbouring Plants to cross-pollinate, 
     * it will \seed", i.e., create a new Plant. The
     * new Plant is \seeded" into a random neighbouring empty cell.
     * 
     * @return (cellsNil >= SEED_MIN 
     *          && cellsPlants >= PLANT_MIN)
     *                                    TRUE if plant cell 
     *                                    meets both.
     */
    public boolean seed() {
        ArrayList <Cell> adjacent = cell.getAdjacentCells();
        int size = adjacent.size();
        int cellsNil = 0;
        int cellsPlants = 0;
        for (int i = 0; i < size; i++) {
            Entity en = adjacent.get(i).getEntity();
            if (en.getEntityID().equals(EntityID.NIL)) {
                cellsNil++;
            } else if (en.getEntityID().equals(EntityID.PLANT)) {
                cellsPlants++;
                continue;
            }   
        }
        return (cellsNil >= SEED_MIN 
                && cellsPlants >= PLANT_MIN);
    }
}
