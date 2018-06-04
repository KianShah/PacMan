package Model.Ghosts;

import Model.GhostAbstract;
import Model.GhostType;

import javax.swing.*;
import java.awt.*;

public class Inky extends GhostAbstract {
    private static Inky inky;
    private static Point initialPos = new Point(50,50);

    private final ImageIcon INKY_EAST = new ImageIcon();
    private final ImageIcon INKY_SOUTH = new ImageIcon();
    private final ImageIcon INKY_WEST = new ImageIcon();
    private final ImageIcon INKY_NORTH = new ImageIcon();

    private Inky(GhostType type, Point pos) {
        super(type, pos);
    }

    @Override
    public Inky getInstance() {
        if (inky == null)
            inky = new Inky(GhostType.INKY, initialPos);

        return inky;
    }
}
