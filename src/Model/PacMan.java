package Model;

import UI.PacManGame;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a PacMan object
 * Implemented with Singleton design pattern
 */
public class PacMan {
    private static Point initialPos = new Point(PacManGame.FRAME_WIDTH/2, PacManGame.FRAME_HEIGHT/2);

    private static final ImageIcon PM_EAST = new ImageIcon("Images/PacMan Images/PacManEAST.png");
    private static final ImageIcon PM_SOUTH = new ImageIcon("Images/PacMan Images/PacManSOUTH.png");
    private static final ImageIcon PM_WEST = new ImageIcon("Images/PacMan Images/PacManWEST.png");
    private static final ImageIcon PM_NORTH = new ImageIcon("Images/PacMan Images/PacManNORTH.png");

    private int speed = 4;
    private static PacMan instance;
    private Point pos;
    private Direction dir;
    private ImageIcon image;

    // Initializes PacMan object facing East at InitialPos
    private PacMan() {
        this.pos = initialPos;
        this.dir = Direction.EAST;
        this.image = PM_EAST;
    }

    // returns Singleton instance of PacMan
    public static PacMan getInstance() {
        if (instance == null)
            instance = new PacMan();

        return instance;
    }

    // EFFECTS: Moves PacMan position SPEED amount in the current direction
    // MODIFIES: this
    public void move() {
        pos.x += speed * dir.getX_dir();
        pos.y += speed * dir.getY_dir();
    }

    // EFFECTS: Sets the direction of the PacMan object
    // MODIFIES: this
    public void setDir(Direction dir) {
        this.dir = dir;
        setCorrectImage();
    }

    // EFFECTS: Sets the PacMan image to face teh current direction
    private void setCorrectImage() {
        switch (dir) {
            case EAST: image = PM_EAST;
                break;
            case SOUTH: image = PM_SOUTH;
                break;
            case WEST: image = PM_WEST;
                break;
            case NORTH: image = PM_NORTH;
                break;
        }
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    // Getter functions
    public Point getPos() {
        return pos;
    }
    public int getSpeed() {
        return speed;
    }
    public Direction getDir() {return dir;}
    public ImageIcon getImage() {return image;}
}
