/**
 * 
 */
package ca.bcit.comp2526.a2a;

/**
 * Class containing instance variables of 
 * cell coordinates, obtainable via 
 * getter and setter methods.
 * @author Kevin Oane
 * @version 1.0.
 *
 */
public class Point {

    private int x;
    private int y;
    
    /**
     * Receives coordinates of a cell.
     * @param x
     *             x-coordinate.
     * @param y
     *             y-coordinate.
     */            
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Receives and sets cell coordinates
     * relative to the cell 2d array and world.
     * @param x
     * @param y
     */
    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Getter method returning x-coordinate.
     * @return x
     *              x-coordinate
     */
    public int getXPoint() {
        return this.x;
    }
    
    /**
     * Getter method returning y-coordinate.
     * @return y
     *              y-coordinate
     */
    public int getYPoint() {
        return this.y;
    }
}
