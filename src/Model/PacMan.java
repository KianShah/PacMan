package Model;

import UI.PacManGame;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a PacMan object
 * Implemented with Singleton design pattern
 */
public class PacMan {
    private static Point initialPos = new Point(PacManGame.FRAME_WIDTH/2, PacManGame.FRAME_HEIGHT/2);

    final static ImageIcon PM_EAST = new ImageIcon("PacManEAST.png");
    final static ImageIcon PM_SOUTH = new ImageIcon("PacManSOUTH.png");
    final static ImageIcon PM_WEST = new ImageIcon("PacManWEST.png");
    final static ImageIcon PM_NORTH = new ImageIcon("PacManNORTH.png");

    private int speed = 4;
    private static PacMan instance;
    private Point pos;
    private Direction dir;
    private ImageIcon image;

    // Initializes Pacman object
    private PacMan(Point pos, Direction dir) {
        this.pos = pos;
        this.dir = dir;
        this.image = PM_EAST;
    }

    // returns Singleton instance of PacMan
    public static PacMan getInstance() {
        if (instance == null)
            instance = new PacMan(initialPos, Direction.EAST);

        return instance;
    }

    // EFFECTS: Moves PacMan position SPEED amount in the currect direction
    // MODIFIES: this
    public void move() {
        pos.x += speed * dir.getX_dir();
        pos.y += speed * dir.getY_dir();
    }

    // EFFECTS: Sets the direction of the PacMan object
    // MODIFIES: this
    public void setDir(Direction dir) {
        this.dir = dir;
        this.image = dir.getImage();
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
