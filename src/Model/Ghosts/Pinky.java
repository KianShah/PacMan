package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Pinky extends GhostAbstract {
    public static final double speed = 6.0;

    public static final ImageIcon PINKY_EAST = new ImageIcon("Images/Pinky Images/PinkyEAST.png");
    public static final ImageIcon PINKY_SOUTH = new ImageIcon("Images/Pinky Images/PinkySOUTH.png");
    public static final ImageIcon PINKY_WEST = new ImageIcon("Images/Pinky Images/PinkyWEST.png");
    public static final ImageIcon PINKY_NORTH = new ImageIcon("Images/Pinky Images/PinkyNORTH.png");

    public final ImageIcon[] images = {PINKY_EAST, PINKY_SOUTH, PINKY_WEST, PINKY_NORTH};

    public Pinky(int speed, Point pos, ImageIcon image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Pinky() {
        super(speed, GhostAbstract.initialPos, PINKY_EAST, Direction.EAST);
    }

    @Override
    public Point getTargetPos() {
        return PacMan.getInstance().getPos();
    }

    @Override
    protected ImageIcon[] getImages() {
        return images;
    }
}
