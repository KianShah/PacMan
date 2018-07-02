package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;
import Util.ImageBuffer;

import java.awt.*;

public class Pinky extends GhostAbstract {
    public static final Point initialPos = new Point(150,50);
    public static final int speed = 4;

    public static final Image PINKY_EAST = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Pinky Images/PinkyEAST.png", Pinky.class);
    public static final Image PINKY_SOUTH = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Pinky Images/PinkySOUTH.png", Pinky.class);
    public static final Image PINKY_WEST = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Pinky Images/PinkyWEST.png", Pinky.class);
    public static final Image PINKY_NORTH = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Pinky Images/PinkyNORTH.png", Pinky.class);

    public final Image[] images = {PINKY_EAST, PINKY_SOUTH, PINKY_WEST, PINKY_NORTH};

    public Pinky(int speed, Point pos, Image image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Pinky() {
        super(speed, initialPos, PINKY_EAST, Direction.EAST);
    }

    @Override
    public Point getTargetPos() {
        return PacMan.getInstance().getPosAhead(4);
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
