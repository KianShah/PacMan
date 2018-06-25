package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

/*
 * Blinky the ghost implemented with Singleton design pattern
 */
public class Blinky extends GhostAbstract {
    public static final Point initialPos = new Point(50,50);
    public static final double speed = 1.0;

    public static final ImageIcon BLINKY_EAST = new ImageIcon("Images/Blinky Images/BlinkyEAST.png");
    public static final ImageIcon BLINKY_SOUTH = new ImageIcon("Images/Blinky Images/BlinkySOUTH.png");
    public static final ImageIcon BLINKY_WEST = new ImageIcon("Images/Blinky Images/BlinkyWEST.png");
    public static final ImageIcon BLINKY_NORTH = new ImageIcon("Images/Blinky Images/BlinkyNORTH.png");

    public final ImageIcon[] images = {BLINKY_EAST, BLINKY_SOUTH, BLINKY_WEST, BLINKY_NORTH};

    public Blinky(int speed, Point pos, ImageIcon image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Blinky() {
        super(speed, initialPos, BLINKY_EAST, Direction.EAST);
    }


    @Override
    public Point getTargetPos() {
        return PacMan.getInstance().getPos();
    }

    /**
     * Returns an array of ImageIcons representing the different images associated with a ghost
     * Contract: EAST image is images[0], SOUTH image is images[1], WEST image is images[2], NORTH image is images[3]
     * @return ImageIcon[] An array of ImageIcons representing the East, South, West and North images of the ghost
     */
    @Override
    public ImageIcon[] getImages() {
        return images;
    }
}
