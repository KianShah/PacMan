package Model.Ghosts;

import Model.GhostAbstract;
import Util.GhostType;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Clyde extends GhostAbstract {
    private static final Point initialPos = new Point(50,50);

    private static final ImageIcon CLYDE_EAST = new ImageIcon();
    private static final ImageIcon CLYDE_SOUTH = new ImageIcon();
    private static final ImageIcon CLYDE_WEST = new ImageIcon();
    private static final ImageIcon CLYDE_NORTH = new ImageIcon();

    public Clyde(GhostType type, Point pos, ImageIcon image, Direction dir) {
        super(type, pos, image, dir);
    }

    public Clyde() {
        super(GhostType.CLYDE, initialPos, CLYDE_EAST, Direction.EAST);
    }

    @Override
    public void setDir(Direction dir) {
        super.setDir(dir);

    }
}
