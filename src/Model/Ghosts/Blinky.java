package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;
import Util.ImageBuffer;

import java.awt.*;

/*
 * Blinky the ghost implemented with Singleton design pattern
 */
public class Blinky extends GhostAbstract {
    public static final Point initialPos = new Point(50,50);
    public static final int speed = 4;

    public static final Image BLINKY_EAST = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Blinky Images/BlinkyEAST.png", Blinky.class);
    public static final Image BLINKY_SOUTH = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Blinky Images/BlinkySOUTH.png", Blinky.class);
    public static final Image BLINKY_WEST = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Blinky Images/BlinkyWEST.png", Blinky.class);
    public static final Image BLINKY_NORTH = ImageBuffer.getImage("/Model/Ghosts/Ghost_Images/Blinky Images/BlinkyNORTH.png", Blinky.class);

    public final Image[] images = {BLINKY_EAST, BLINKY_SOUTH, BLINKY_WEST, BLINKY_NORTH};

    public Blinky(int speed, Point pos, Image image, Direction dir) {
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
    public Image[] getImages() {
        return images;
    }
}
