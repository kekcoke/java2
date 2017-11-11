package ca.bcit.comp2526.a2a;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * GameFrame (Window) attached to world.
 * @author Kevin Oane, revising editor.
 * @version 1.0
 */
public class GameFrame extends JFrame {
    
    /**
     * Generated sVUID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private final World world;

    /**
     * Constructor accepting World object
     * for reference.
     * @param w
     *         World.
     */
    public GameFrame(final World w) {
        world = w;
    }

    /**
     * Initializes GameFrame.
     */
    public void init() {
        setTitle("Assignment 2a");
        setLayout(new GridLayout(world.getRowCount(), world.getColumnCount()));

        for (int row = 0; row < world.getRowCount(); row++) {
            for (int col = 0; col < world.getColumnCount(); col++) {
                add(world.getCellAt(row, col));
            }
        }

        addMouseListener(new TurnListener(this));
    }

    /**
     * Listens for mouse-click.
     */
    public void takeTurn() {
        world.takeTurn();
        repaint();
    }
}
