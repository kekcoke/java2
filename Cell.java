/**
 * 
 */
package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


/**
 * Cell can hold a Plant or an Herbivore or nothing
 * Represented as a square in the world.
 * @author Kevin Oane
 * @version 1.0.
 */
public class Cell extends JPanel {

    /**
     * Generated serialVersionUID.
     */    
    private static final long serialVersionUID = -7084372719579364909L;

    /**
     * Maximum integer number to be randomized.
     */
    private static final int MAX_NUM = 100;

    /**
     * Minimum generated random integer to spawn a herbivore.
     */
    private static final int HERB_NUM = 80;

    /**
     * Minimum generated random integer to spawn a plant.
     */
    private static final int PLANT_NUM = 50;

    private final World world;

    private Point cellAt;

    private Entity entity;


    /**
     * Creates Cell object in the World.
     * @param world
     *            World object that the cell resides in.
     * @param row
     *            Cell's row (y) location.
     * @param column
     *            Cell's column (x) location.
     */           
    public Cell(World world, int row, int column) {
        this.world = world;
        this.cellAt = new Point(row, column);
        init();
    }

    /**
     * Randomly generates a cell entity and draws black border around cell.
     */
    public void init() {
        setBorder(BorderFactory.createLineBorder(Color.black));

        int num = RandomGenerator.nextNumber(MAX_NUM);
        if (num >= HERB_NUM) {
            entity = new Herbivore(this);
        } else if (num <= PLANT_NUM) {
            entity = new Plant(this);
        } else {
            entity = new Nil(this);
        }
        setEntity(entity);
    }

    /**
     * Returns 3, 5, or 8 adjacent cells
     * and their COORDINATES relative
     * to cell's location in the World.
     * @return 
     *         Adjacent cells (possibly 3, 5, or 8).
     */      
    public ArrayList<Cell> getAdjacentCells() { 
    	ArrayList<Cell> adjacentCells = new ArrayList<Cell>();
        
    	for (int row = (cellAt.y - 1); row <= (cellAt.y + 1); row++) {
            for (int col = (cellAt.x - 1); col <= (cellAt.x + 1); col++) {      
                if ((cellAt.x == col) && (cellAt.y == row)) {
                    continue;
                }
                if ((col >= 0 && col <= (world.getColumnCount() - 1)) 
                        && (row >= 0 && row <= (world.getRowCount() - 1))) {
                    adjacentCells.add(world.getCellAt(row, col));
                    //System.out.println("Took cell from R " + row + " & C "+col);
                }
            }
        }
        return adjacentCells;
    }
    
    /**
     * Creates an nil-empty cell object
     * on a dead herbivore. 
     * Invokes init(), thus color assigned
     * on instantiation.
     */
    public void isDead() {
        this.setEntity(new Nil(this)); 
    }
    
    /**
     * Herbivore eats a plant.
     * Sets old cell into an nil-object cell.
     * @param moveInto
     *                Plant-occupied cell where 
     *                herbivore is moving into.
     */
    public void eat(final Cell moveInto, final Cell moveFrom) {
    	System.out.println("I am a : " + this.getEntity().getEntityID() + " going to moveInto " + moveInto.getEntity().getEntityID());
        moveInto.setEntity(this.getEntity()).init();
               
        moveFrom.setEntity(new Nil(moveFrom)); 
        //still is herbivore after this.
        System.out.println("Old cell is now: " + this.getEntity().getEntityID() + " movedInto cell is now " + moveInto.getEntity().getEntityID());
        
    }
    
    /**
     * Herbivore moving into an empty cell.
     * Herbivore moves only if no adjacent cells 
     * contain a plant.
     * 
     * 154. Assign moving entity to 'en'
     * 155. Assign cell entity 
     * using moving cell's current entity.
     * 156. Set new Entity into cell.
     * Old cell gets new entity and init() colors it.
     * 157. Init new cell
     * @param moveInto
     *                Empty cell herbivore object is moving into.
     */
    public void swapEntities(Cell moveInto) {
        Entity en = moveInto.getEntity(); 
        moveInto.setEntity(this.getEntity()); 
        this.setEntity(en).init(); 
        moveInto.getEntity().init(); 
    }
    
    /**
     * Spawns a plant cell from an empty one.
     * @param sproutFrom
     *             this Cell, a plant.
     *                
     */
    public void sprout(final Cell sproutFrom) {
        ArrayList<Cell> adjacent = sproutFrom.getAdjacentCells();
        boolean grown = false;
        int size = adjacent.size();
        
        while (!grown) {
            int randNum = RandomGenerator.nextNumber(size - 1);
            Entity en;
            do {
                en = adjacent.get(randNum).getEntity();
                } while (!(en.getEntityID() == EntityID.NIL));
            
            {
            	System.out.printf("\nsproutFrom is : %s, adjacent is %s", sproutFrom.getEntity().getEntityID(), adjacent.get(randNum).getEntity().getEntityID());
            	adjacent.get(randNum).setEntity(new Plant(this));
                //repaint();.this.setEntity(sproutFrom.getEntity());
                System.out.printf("\nsproutFrom NOW is : %s, adjacent NOW is %s \n", sproutFrom.getEntity().getEntityID(), adjacent.get(randNum).getEntity().getEntityID());//INITS CELL NOT ENTITY?
                //this.getEntity().init(); //INITS CELL METHOD, NOT ENTITY's?
                grown = true;
            }
        }

    }
    
    /**
     * Returns current entity inside this given cell.
     * @return 
     *         ArrayList containing cell coordinates 
     *         around the particular cell.
     */
    public Entity getEntity() {
        return this.entity;
    }
    
    /**
     * Returns entityID in this instance of cell.
     * @param en
     *           entityID
     * @return
     *           entityID
     */
    public Entity setEntity(Entity en) {
        entity = en;
        return entity;
    }
    
        /**
     * Returns cell coordinates 
     * relative to world.
     * @return 
     *         cellAt (cell's coordinates)
     */
    public Point getLocation() {
        return this.cellAt;
    }
    
    /**
     * Gets instance variable world in Cell class.
     * @return world 
     *               world object.
     */
    public World getWorld() {
        return world;
    }
}
