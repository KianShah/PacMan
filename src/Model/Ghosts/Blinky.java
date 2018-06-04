package Model.Ghosts;

import Model.GhostAbstract;
import Model.GhostType;

import javax.swing.*;
import java.awt.*;

/*
 * Blinky the ghost implemented with Singleton design pattern
 */
public class Blinky extends GhostAbstract {
    private static Blinky blinky;
    private static Point initialPos = new Point(50,50);

    private final ImageIcon BLINKY_EAST = new ImageIcon();
    private final ImageIcon BLINKY_SOUTH = new ImageIcon();
    private final ImageIcon BLINKY_WEST = new ImageIcon();
    private final ImageIcon BLINKY_NORTH = new ImageIcon();

    private Blinky(GhostType type, Point pos) {
        super(type, pos);
    }

    @Override
    public Blinky getInstance() {
        if (blinky == null)
            blinky = new Blinky(GhostType.BLINKY, initialPos);

        return blinky;
    }
}
