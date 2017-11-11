package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
/**
 *  Herbivore moves into adjacent Cells randomly 
 *  and will either eat a plant (if cell has one).
 *  If empty, herbivore starves to death.
 *  Herbivore must not move to cell containing herbivore.
 *  @author Kevin Oane
 *  @version 1.0.
 */
public class Herbivore extends Entity {

    /**
     * Generated serialVersionUID.
     */
    private static final long serialVersionUID = -4361425553964034383L;

    private Cell cell;

    private int life = 10;

    /**
     * Class constructor assigning
     * herbivore object to specified
     * cell location.
     * @param cell
     *                Accepts cell location.
     */
    public Herbivore(Cell cell) {
        super(cell, EntityID.HERBIVORE, Color.yellow, new JLabel("H"));
        this.cell = cell;  
        init();
    }

    /**
     * Sets cell background to yellow.
     */
    public void init() {
        super.init();
    	//cell.setBackground(Color.yellow);
        //cell.add(new JLabel("H"));
    }

    /**
     * Decreases herbivore life by 1 point if 
     * unable to eat a plant-cell at the end of a turn.
     */
    public void decreaseLife() {
        life--;
    }
    /**
     * Puts Herbivore to location in Cell 2d array
     * in world.
     * @param location
     *                Cell coordinates
     */
    public void setCell(Cell location) {
        this.cell = location;
    }

    /**
     * Gets specified cell.
     * @return
     *        cell specified.
     */
    public Cell getCell() {
        return cell;
    }

    /**
     * Moves herbivore one-cell and 
     * will eat a plant should adjacent
     * cell contain one. In effect restores 
     * lifespan to maximum. Otherwise, herbivore
     * moves and has lifespan decreased by 1 per turn.
     * @return 
     */
    public Cell move() {
        Cell oldCell = cell; 
    	boolean hasMoved = false;
        ArrayList <Cell> adjacent = cell.getAdjacentCells();
        int size = adjacent.size();
        int moveRandom = RandomGenerator.nextNumber(size - 1);
        Entity en;

            for (int i = 0; i < adjacent.size(); i++) {
                if (adjacent.get(i).getEntity().getEntityID()
                        .equals(EntityID.PLANT)) {
                	System.out.println("I am a : " + this.getEntityID() + " going to moveInto " + adjacent.get(i).getEntity().getEntityID());
                    System.out.printf(" is eating plant cell in %d %d\n", (int)adjacent.get(i).getLocation().getY() , (int) adjacent.get(i).getLocation().getX());
                    System.out.printf("%s\n", cell.getEntity().getEntityID());
                    cell.eat(adjacent.get(i), cell);
                    //make cell reference to old, put info, put back after move
                    cell = oldCell;
                    System.out.printf("%s\n", oldCell.getEntity().getEntityID());
                    System.out.println("Old cell is now: " + this.getEntityID() + " movedInto cell is now " + adjacent.get(i).getEntity().getEntityID());
                    break; 
                } else  {
                	//CTRL FLOW DOESN'T GO OVER HERE, EVER. 
                	if (i == (size - 1)) {
                        do {
                        en = adjacent.get(moveRandom).getEntity();
                        } while (!(en.getEntityID() == EntityID.NIL));
                    	System.out.printf("\n%s\n", adjacent.get(moveRandom).getEntity());
                    	System.out.printf("\n Going to nil cell\n");
                    	cell.swapEntities(adjacent.get(moveRandom));
                    	System.out.printf("\n%s\n", adjacent.get(moveRandom).getEntity());
                        life--;
                	    }
                    }
                }
            return cell;
            }
   

    /**
     * Returns this Herbivore's life.
     * @return Lifespan
     *                 Herbivore's lifespan.
     *        
     */
    public int getLifeSpan() {
        return life;
    }

}
