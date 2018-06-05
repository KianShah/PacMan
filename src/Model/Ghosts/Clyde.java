package Model.Ghosts;

import Model.GhostAbstract;
import Util.GhostType;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Clyde extends GhostAbstract {
    private static final Point initialPos = new Point(50,50);

    private static final ImageIcon CLYDE_EAST = new ImageIcon("Images/Clyde Images/ClydeEAST.png");
    private static final ImageIcon CLYDE_SOUTH = new ImageIcon("Images/Clyde Images/ClydeSOUTH.png");
    private static final ImageIcon CLYDE_WEST = new ImageIcon("Images/Clyde Images/ClydeWEST.png");
    private static final ImageIcon CLYDE_NORTH = new ImageIcon("Images/Clyde Images/ClydeNORTH.png");

    public Clyde(GhostType type, Point pos, ImageIcon image, Direction dir) {
        super(type, pos, image, dir);
    }

    public Clyde() {
        super(GhostType.CLYDE, initialPos, CLYDE_EAST, Direction.EAST);
    }

    @Override
    public void setDir(Direction dir) {
        super.setDir(dir);
        setCorrectImage();
    }

    private void setCorrectImage() {
        switch (super.getDir()) {
            case EAST:  super.setImage(CLYDE_EAST);
                break;
            case SOUTH:  super.setImage(CLYDE_SOUTH);
                break;
            case WEST:  super.setImage(CLYDE_WEST);
                break;
            case NORTH:  super.setImage(CLYDE_NORTH);
                break;
            default: // do nothing
        }
    }
}
