package Model;

import UI.PacManGame;
import Util.Direction;
import Util.ImageBuffer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Represents a PacMan object
 * Implemented with Singleton design pattern
 */
public class PacMan extends MoveableSprite{
    public static final Point initialPos = new Point(PacManGame.FRAME_WIDTH/2, PacManGame.FRAME_HEIGHT/2);
    private static int speed = 7;

    public static final ImageIcon PM_EAST = ImageBuffer.getImage("/Model/PacMan Images/PacManEAST.png", PacMan.class);
    public static final ImageIcon PM_SOUTH = ImageBuffer.getImage("/Model/PacMan Images/PacManSOUTH.png", PacMan.class);
    public static final ImageIcon PM_WEST = ImageBuffer.getImage("/Model/PacMan Images/PacManWEST.png", PacMan.class);
    public static final ImageIcon PM_NORTH = ImageBuffer.getImage("/Model/PacMan Images/PacManNORTH.png", PacMan.class);

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

    private static ImageIcon getImage(String filename) {
        try {
            URL url = PacMan.class.getResource(filename);
            Image image = ImageIO.read(url);
            return new ImageIcon(image);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
