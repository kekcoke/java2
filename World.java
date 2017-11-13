package ca.bcit.comp2526.a2a;

/**
 * World
 *(a) Holds Cells and containing Entities (Herbivore & Plant).
 * ActionListener present to take turn.
 * @author Kevin Oane
 * @version 1.0.
 *
 */
class World {
	
    static int turnCount = 0;
    
    private Cell[][] cells;
    
    private final int rows;
    
    private final int columns;
    
    private int herbsRemoved = 0;
    
    private int seeded = 0;
    
    private Entity en;
    /**
     * Constructs the world.
     * Holds cells.
     * When world is created, cells will havce
     *     20% chance = Herbivore
     *     30% chance = Plant
     * @param rows : X coords.
     * @param cols : Y coords.
     */
    World(final int rows, final int cols) {
        this.rows = rows;
        this.columns = cols;
        this.cells = new Cell[rows][cols]; 
    }
      
    /**
     * 
     * Puts the Cells on the world and adds the 
     * appropriate number of Herbivores and
     * Plants
     * Creates world.
     * Connect GameFrame to Word,
     * connect row & col # cell, 
     * cell inhabitant using RandomGenerator.  
     */
    public void init() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                Cell newCell = new Cell(this, row, col); 
                this.cells[row][col] = newCell;
            }
        }
    }

    /**
     * Retrieves the requested Cell 
     * from the specified location 
     * in the World.
     * @param row
     *               Row relative to world.
     * @param column
     *               Column relative to world.
     * @return cells[][]
     *               Cell at this array position.
     */
    public Cell getCellAt(int row, int column) {
        return this.cells[row][column];
    }
    
    /**
     * Removes dead herbivores, checks each plant to see if it can seed
     * and then moves remaining living
     * Herbivores one Cell.
     */
    public void takeTurn() {
        removeHerbivores(); 
        seedPlants();     
        moveHerbivores();  
        
    System.out.print(turnCount++);
    }
    
    /**
     * Removes dead herbivores, checking if lifespan = 0.
     * If so, set herbivore entity to NULL.
     */
    public void removeHerbivores() {
        System.out.println("Removing");
    	for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                Entity en  = this.cells[row][col].getEntity();
                if ((en.getEntityID().equals(EntityID.HERBIVORE))
                        && (((Herbivore) en).getLifeSpan() == 0)) {
                        cells[row][col].isDead();
                        herbsRemoved++;
                    } 
            }
        }
        System.out.printf("Done removing %d herbs", herbsRemoved);
    }
    
    /**
     * Searches every Plant entity in every Cell.
     * and invokes spreadPlant cell method on such entity.
     */
    public void seedPlants() {
        System.out.println("Seeding");
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                Entity en  = this.cells[row][col].getEntity();
                if (en.getEntityID().equals(EntityID.PLANT)) {
/*                    boolean sprout = false;
                    if (sprout == ((Plant) en).seed()) {
                        cells[row][col].sprout(cells[row][col]);
                        seeded++;
                    }*/
                }
            }
        }
        System.out.println("Done seeding" + seeded + " cells.");
    }
    
    /**
     * Searches every Plant entity in every Cell
     * and invokes moveHerbivores method on such entity.
     */
    public void moveHerbivores() {
        System.out.println("Moving");
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                Entity en  = this.cells[row][col].getEntity();
                if (en.getEntityID().equals(EntityID.HERBIVORE) &&
                		((Herbivore)en).getLifeSpan() > 0) {
                	 
                	
                	    System.out.printf("\nAt World:Row %s. Col %s\n", row, col);
                        System.out.printf("At World old cell: %s\n",this.cells[row][col].getEntity().getEntityID());
                        ((Herbivore) en).move();
                        System.out.printf("At World old cell: %s\n",this.cells[row][col].getEntity().getEntityID());
                        this.cells[row][col].getEntity().init();
                    }
                
            } 
        }
        System.out.println("Done moving");
    }
    
/*    public Entity paint() {
        Entity en;
    	for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                en  = this.cells[row][col].getEntity();
                en.init();
            }
        }
        return en;
    }*/

    
    /**
     * Return number of rows in World.
     * @return ROWS
     *              No. of rows.
     */
    public int getRowCount() {
        return this.rows;
    }
    
    /**
     * Return number of columns in World.
     * @return COLUMNS
     *              No. of columns.
     */
    public int getColumnCount() {
        return this.columns;
    }
    
}
