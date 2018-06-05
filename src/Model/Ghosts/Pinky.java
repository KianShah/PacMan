package Model.Ghosts;

import Model.GhostAbstract;
import Util.GhostType;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Pinky extends GhostAbstract {
    private static final Point initialPos = new Point(50,50);

    private static final ImageIcon PINKY_EAST = new ImageIcon("Images/Pinky Images/PinkyEAST.png");
    private static final ImageIcon PINKY_SOUTH = new ImageIcon("Images/Pinky Images/PinkySOUTH.png");
    private static final ImageIcon PINKY_WEST = new ImageIcon("Images/Pinky Images/PinkyWEST.png");
    private static final ImageIcon PINKY_NORTH = new ImageIcon("Images/Pinky Images/PinkyNORTH.png");

    public Pinky(GhostType type, Point pos, ImageIcon image, Direction dir) {
        super(type, pos, image, dir);
    }

    public Pinky() {
        super(GhostType.PINKY, initialPos, PINKY_EAST, Direction.EAST);
    }

    @Override
    public void setDir(Direction dir) {
        super.setDir(dir);
        setCorrectImage();
    }

    private void setCorrectImage() {
        switch (super.getDir()) {
            case EAST:  super.setImage(PINKY_EAST);
                break;
            case SOUTH:  super.setImage(PINKY_SOUTH);
                break;
            case WEST:  super.setImage(PINKY_WEST);
                break;
            case NORTH:  super.setImage(PINKY_NORTH);
                break;
            default: // do nothing
        }
    }
}
