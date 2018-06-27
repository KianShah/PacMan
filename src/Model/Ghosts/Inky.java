package Model.Ghosts;

import Model.GhostAbstract;
import Model.PMGame;
import Util.Direction;
import Util.Vector;

import javax.swing.*;
import java.awt.*;

public class Inky extends GhostAbstract {
    public static final Point initialPos = new Point(100,50);
    public static final int speed = 3;

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
        Point X = PMGame.getGame().getPacMan().getPosAhead(2);
        Blinky blinky = (Blinky) PMGame.getGame().getGhosts()[0];
        Vector difference = new Vector(X.x - blinky.getPos().x, X.y - blinky.getPos().y);
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
