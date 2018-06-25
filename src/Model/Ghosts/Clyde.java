package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;
import Util.Distance;

import javax.swing.*;
import java.awt.*;

public class Clyde extends GhostAbstract {
    public static final Point initialPos = new Point(50,50);
    public static final double speed = 4.0;
    public static final Point scatter_point = new Point(50, 300);
    private boolean is_scatter = false;

    public static final ImageIcon CLYDE_EAST = new ImageIcon("Images/Clyde Images/ClydeEAST.png");
    public static final ImageIcon CLYDE_SOUTH = new ImageIcon("Images/Clyde Images/ClydeSOUTH.png");
    public static final ImageIcon CLYDE_WEST = new ImageIcon("Images/Clyde Images/ClydeWEST.png");
    public static final ImageIcon CLYDE_NORTH = new ImageIcon("Images/Clyde Images/ClydeNORTH.png");

    public final ImageIcon[] images = {CLYDE_EAST, CLYDE_SOUTH, CLYDE_WEST, CLYDE_NORTH};

    public Clyde(int speed, Point pos, ImageIcon image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Clyde() {
        super(speed, initialPos, CLYDE_EAST, Direction.EAST);
    }

    @Override
    public Point getTargetPos() {
        if (Distance.getDistance(getPos(), PacMan.getInstance().getPos()) <= 8)
            is_scatter = true;

        if (getPos() == scatter_point)
            is_scatter = false;

        if (is_scatter)
            return scatter_point;

        else
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
