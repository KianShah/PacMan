package Model.Ghosts;

import Model.GhostAbstract;
import Util.GhostType;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Inky extends GhostAbstract {
    private static final Point initialPos = new Point(50,50);

    private static final ImageIcon INKY_EAST = new ImageIcon("Images/Inky Images/InkyEAST.png");
    private static final ImageIcon INKY_SOUTH = new ImageIcon("Images/Inky Images/InkySOUTH.png");
    private static final ImageIcon INKY_WEST = new ImageIcon("Images/Inky Images/InkyWEST.png");
    private static final ImageIcon INKY_NORTH = new ImageIcon("Images/Inky Images/InkyNORTH.png");

    public Inky(GhostType type, Point pos, ImageIcon image, Direction dir) {
        super(type, pos, image, dir);
    }

    public Inky() {
        super(GhostType.INKY, initialPos, INKY_EAST, Direction.EAST);
    }

    @Override
    public void setDir(Direction dir) {
        super.setDir(dir);
        setCorrectImage();
    }

    private void setCorrectImage() {
        switch (super.getDir()) {
            case EAST:  super.setImage(INKY_EAST);
                break;
            case SOUTH:  super.setImage(INKY_SOUTH);
                break;
            case WEST:  super.setImage(INKY_WEST);
                break;
            case NORTH:  super.setImage(INKY_NORTH);
                break;
            default: // do nothing
        }
    }
}
