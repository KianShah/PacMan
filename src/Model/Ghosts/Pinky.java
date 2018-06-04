package Model.Ghosts;

import Model.GhostAbstract;
import Model.GhostType;

import javax.swing.*;
import java.awt.*;

public class Pinky extends GhostAbstract {
    private static Pinky pinky;
    private static Point initialPos = new Point(50,50);

    private final ImageIcon PINKY_EAST = new ImageIcon();
    private final ImageIcon PINKY_SOUTH = new ImageIcon();
    private final ImageIcon PINKY_WEST = new ImageIcon();
    private final ImageIcon PINKY_NORTH = new ImageIcon();

    private Pinky(GhostType type, Point pos) {
        super(type, pos);
    }

    @Override
    public Pinky getInstance() {
        if (pinky == null)
            pinky = new Pinky(GhostType.PINKY, initialPos);

        return pinky;
    }
}
