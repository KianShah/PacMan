package Model;

import UI.PacManGame;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a PacMan object
 * Implemented with Singleton design pattern
 */
public class PacMan extends MoveableSprite{
    public static Point initialPos = new Point(PacManGame.FRAME_WIDTH/2, PacManGame.FRAME_HEIGHT/2);
    private static int speed = 7;

    public static final ImageIcon PM_EAST = new ImageIcon("Images/PacMan Images/PacManEAST.png");
    public static final ImageIcon PM_SOUTH = new ImageIcon("Images/PacMan Images/PacManSOUTH.png");
    public static final ImageIcon PM_WEST = new ImageIcon("Images/PacMan Images/PacManWEST.png");
    public static final ImageIcon PM_NORTH = new ImageIcon("Images/PacMan Images/PacManNORTH.png");

    public static final ImageIcon[] images = new ImageIcon[] {PM_EAST, PM_SOUTH, PM_WEST, PM_NORTH};

    private static PacMan instance;


    // Initializes PacMan object facing East at InitialPos
    private PacMan() {
        super(speed, initialPos, PM_EAST, Direction.EAST);
    }

    // returns Singleton instance of PacMan
    public static PacMan getInstance() {
        if (instance == null)
            instance = new PacMan();

        return instance;
    }

    /**
     * Returns an array of ImageIcons representing the different images associated with a ghost
     * Contract: EAST image is images[0], SOUTH image is images[1], WEST image is images[2], NORTH image is images[3]
     *
     * @return ImageIcon[] An array of ImageIcons representing the East, South, West and North images of the ghost
     */
    @Override
    public ImageIcon[] getImages() {
        return images;
    }
}
