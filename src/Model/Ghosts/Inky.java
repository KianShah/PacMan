package Model.Ghosts;

import Model.GhostAbstract;
import Util.GhostType;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Inky extends GhostAbstract {
    private static final Point initialPos = new Point(50,50);

    private static final ImageIcon INKY_EAST = new ImageIcon();
    private static final ImageIcon INKY_SOUTH = new ImageIcon();
    private static final ImageIcon INKY_WEST = new ImageIcon();
    private static final ImageIcon INKY_NORTH = new ImageIcon();

    public Inky(GhostType type, Point pos, ImageIcon image, Direction dir) {
        super(type, pos, image, dir);
    }

    public Inky() {
        super(GhostType.INKY, initialPos, INKY_EAST, Direction.EAST);
    }

    @Override
    public void setDir(Direction dir) {
        super.setDir(dir);

    }
}
