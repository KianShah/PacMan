package Model;

import UI.PacManGame;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public abstract class MoveableSprite {
    private int speed;
    private ImageIcon image;
    private Point pos;
    private Direction dir;

    protected MoveableSprite(int speed, Point pos, ImageIcon image, Direction dir) {
        this.speed = speed;
        this.pos = pos;
        this.image = image;
        this.dir = dir;
    }

    public void move() {
        if (inBounds()) {
            pos = getPosAhead(1);
        }
    }

    /**
     * Returns the position of Pacman if it were to move X moves ahead
     * @param X The number of times we want to move Pacman forward
     * @return The point representing the position X moves ahead
     */
    public Point getPosAhead(int X) {
        Point newPos = new Point();

        newPos.x = pos.x + (int) speed * dir.getX_dir() * X;
        newPos.y = pos.y + (int) speed * dir.getY_dir() * X;
        return newPos;
    }

    protected boolean inBounds() {
        Point posAhead = getPosAhead(1);

        return (posAhead.x >= -5 && posAhead.x <= PacManGame.FRAME_WIDTH - 70) &&
               (posAhead.y >= -5 && posAhead.y <= PacManGame.FRAME_HEIGHT - 140);
    }


    public void setDir(Direction dir) {
        this.dir = dir;
                ImageIcon[] images = getImages();

        switch (dir) {
            case EAST:
                image = images[0];
                break;
            case SOUTH:
                image = images[1];
                break;
            case WEST:
                image = images[2];
                break;
            case NORTH:
                image = images[3];
                break;
            default: // do nothing
        }
    }

    // Getter methods
    /**
     * Returns an array of ImageIcons representing the different images associated with a ghost
     * Contract: EAST image is images[0], SOUTH image is images[1], WEST image is images[2], NORTH image is images[3]
     * @return ImageIcon[] An array of ImageIcons representing the East, South, West and North images of the ghost
     */
    public abstract ImageIcon[] getImages();

    public ImageIcon getImage() {
        return image;
    }
    public double getSpeed() {
        return speed;
    }
    public Point getPos() {
        return pos;
    }
    public Direction getDir() {
        return dir;
    }
}
