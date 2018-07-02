package Model.Ghosts;

import Model.GhostAbstract;
import Model.PMGame;
import Util.Direction;
import Util.ImageBuffer;
import Util.Vector;

import java.awt.*;

public class Inky extends GhostAbstract {
    public static final Point initialPos = new Point(100,50);
    public static final int speed = 3;

    public static final Image INKY_EAST = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Inky Images/InkyEAST.png", Inky.class);
    public static final Image INKY_SOUTH = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Inky Images/InkySOUTH.png", Inky.class);
    public static final Image INKY_WEST = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Inky Images/InkyWEST.png", Inky.class);
    public static final Image INKY_NORTH = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Inky Images/InkyNORTH.png", Inky.class);

    private final Image[] images = {INKY_EAST, INKY_SOUTH, INKY_WEST, INKY_NORTH};

    public Inky(int speed, Point pos, Image image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Inky() {
        super(speed, initialPos, INKY_EAST, Direction.EAST);
    }

    @Override
    public Point getTargetPos() {
        Point X = PMGame.getInstance().getPacMan().getPosAhead(5);
        Blinky blinky = (Blinky) PMGame.getInstance().getGhosts()[0];
        Vector difference = new Vector(X.x - blinky.getPos().x, X.y - blinky.getPos().y);
        difference = difference.multiply(2);

        return (Vector.toVector(this.getPos()).add(difference)).toPoint();
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
