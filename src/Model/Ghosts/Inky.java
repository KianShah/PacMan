package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;
import Util.Vector;

import javax.swing.*;
import java.awt.*;

public class Inky extends GhostAbstract {
    public static final Point initialPos = new Point(50,50);
    public static final double speed = 2.0;

    public static final ImageIcon INKY_EAST = new ImageIcon("Images/Inky Images/InkyEAST.png");
    public static final ImageIcon INKY_SOUTH = new ImageIcon("Images/Inky Images/InkySOUTH.png");
    public static final ImageIcon INKY_WEST = new ImageIcon("Images/Inky Images/InkyWEST.png");
    public static final ImageIcon INKY_NORTH = new ImageIcon("Images/Inky Images/InkyNORTH.png");

    private final ImageIcon[] images = {INKY_EAST, INKY_SOUTH, INKY_WEST, INKY_NORTH};

    public Inky(int speed, Point pos, ImageIcon image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Inky() {
        super(speed, initialPos, INKY_EAST, Direction.EAST);
    }

    @Override
    public Point getTargetPos() {
        Point X = PacMan.getInstance().getPosAhead(2);
        Vector difference = new Vector(Math.abs(getPos().x - X.x), Math.abs(getPos().y - X.y));
        difference.multiply(2);

        return (Vector.toVector(this.getPos()).add(difference)).toPoint();
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
