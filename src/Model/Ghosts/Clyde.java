package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;
import Util.Distance;
import Util.ImageBuffer;

import java.awt.*;

public class Clyde extends GhostAbstract {
    public static final Point initialPos = new Point(200,50);
    public static final int speed = 3;
    public static final Point scatter_point = new Point(10, 300);
    private boolean is_scatter = false;

    public static final Image CLYDE_EAST = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Clyde Images/ClydeEAST.png", Clyde.class);
    public static final Image CLYDE_SOUTH = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Clyde Images/ClydeSOUTH.png", Clyde.class);
    public static final Image CLYDE_WEST = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Clyde Images/ClydeWEST.png", Clyde.class);
    public static final Image CLYDE_NORTH = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Clyde Images/ClydeNORTH.png", Clyde.class);

    public final Image[] images = {CLYDE_EAST, CLYDE_SOUTH, CLYDE_WEST, CLYDE_NORTH};

    public Clyde(int speed, Point pos, Image image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Clyde() {
        super(speed, initialPos, CLYDE_EAST, Direction.EAST);
    }

    @Override
    public Point getTargetPos() {
        Point pos = getPos();
        Point pacman_pos = PacMan.getInstance().getPos();

        if (Distance.getDistance(pos, pacman_pos) <= 250)
            is_scatter = true;

        if ((pos.x <= scatter_point.x + 5 && pos.x >= scatter_point.x - 5) &&
                (pos.y <= scatter_point.y + 5 && pos.y >= scatter_point.y - 5)) // Defines a box 5 pixels wide
            is_scatter = false;

        if (is_scatter)
            return scatter_point;

        else
            return pacman_pos;

    }

    /**
     * Returns an array of ImageIcons representing the different images associated with a ghost
     * Contract: EAST image is images[0], SOUTH image is images[1], WEST image is images[2], NORTH image is images[3]
     * @return ImageIcon[] An array of ImageIcons representing the East, South, West and North images of the ghost
     */
    @Override
    public Image[] getImages() {
        return images;
    }
}
