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
		//super.init();
	    cell.setBackground(Color.yellow);
		cell.add(new JLabel("H"));
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
	public void move() {
		//for (cE;;)
		//ArrayList <Cell> adjacent = cell.getAdjacentCells()
		//int size = adjacent.size();
		int moveRandom;
		int size = cell.getAdjacentCells().size();
		int count = 0;
		do {
			moveRandom = RandomGenerator.nextNumber(cell.getAdjacentCells().size() - 1);
			count++;
		} while ((count != size) && (!cell.getAdjacentCells().get(moveRandom).getEntity().getEntityID().equals(EntityID.PLANT))
				);
		
		if(cell.getAdjacentCells().get(moveRandom).getEntity().getEntityID().equals(EntityID.PLANT)) {
			
			cell.eat((cell.getAdjacentCells().get(moveRandom)), cell);
			
		} else if(cell.getAdjacentCells().get(moveRandom).getEntity().getEntityID().equals(EntityID.NIL)) {
			
			cell.swapEntities(cell.getAdjacentCells().get(moveRandom));
			
			life--;
		}

		//while moveStatus false, iterate every cell, return true, randomval
		//cells that contain plant
		//else, randomvalue and move


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
