package Model.Ghosts;

import Model.GhostAbstract;
import Util.GhostType;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Pinky extends GhostAbstract {
    private static final Point initialPos = new Point(50,50);

    private static final ImageIcon PINKY_EAST = new ImageIcon();
    private static final ImageIcon PINKY_SOUTH = new ImageIcon();
    private static final ImageIcon PINKY_WEST = new ImageIcon();
    private static final ImageIcon PINKY_NORTH = new ImageIcon();

    public Pinky(GhostType type, Point pos, ImageIcon image, Direction dir) {
        super(type, pos, image, dir);
    }

    public Pinky() {
        super(GhostType.PINKY, initialPos, PINKY_EAST, Direction.EAST);
    }

    @Override
    public void setDir(Direction dir) {
        super.setDir(dir);

    }
}
