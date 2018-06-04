package Model.Ghosts;

import Model.GhostAbstract;
import Util.GhostType;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

/*
 * Blinky the ghost implemented with Singleton design pattern
 */
public class Blinky extends GhostAbstract {
    private static final Point initialPos = new Point(50,50);

    private static final ImageIcon BLINKY_EAST = new ImageIcon("BlinkyEAST.png");
    private static final ImageIcon BLINKY_SOUTH = new ImageIcon();
    private static final ImageIcon BLINKY_WEST = new ImageIcon();
    private static final ImageIcon BLINKY_NORTH = new ImageIcon();

    public Blinky(GhostType type, Point pos, ImageIcon image, Direction dir) {
        super(type, pos, image, dir);
    }

    public Blinky() {
        super(GhostType.BLINKY, initialPos, BLINKY_EAST, Direction.EAST);
    }

    @Override
    public void setDir(Direction dir) {
        super.setDir(dir);

    }
}
