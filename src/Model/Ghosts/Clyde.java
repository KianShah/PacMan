package Model.Ghosts;

import Model.GhostAbstract;
import Model.GhostType;

import javax.swing.*;
import java.awt.*;

public class Clyde extends GhostAbstract {
    private static Clyde clyde;
    private static Point initialPos = new Point(50,50);

    private final ImageIcon CLYDE_EAST = new ImageIcon();
    private final ImageIcon CLYDE_SOUTH = new ImageIcon();
    private final ImageIcon CLYDE_WEST = new ImageIcon();
    private final ImageIcon CLYDE_NORTH = new ImageIcon();

    private Clyde(GhostType type, Point pos) {
        super(type, pos);
    }

    @Override
    public Clyde getInstance() {
        if (clyde == null)
            clyde = new Clyde(GhostType.CLYDE, initialPos);

        return clyde;
    }
}
