package Model;

import Util.Direction;

import javax.swing.*;
import java.awt.*;

import static Util.Direction.*;

/*
 * Abstract ghost class to implement our observer design pattern
 */
public abstract class GhostAbstract {
    private double speed;
    private Point pos;
    private ImageIcon image;
    private Direction dir;

    protected GhostAbstract(double speed, Point pos, ImageIcon image, Direction dir) {
        this.speed = speed;
        this.pos = pos;
        this.image = image;
        this.dir = dir;
    }

    /**
     *  Updates the ghost's direction and position
     */
    public void update() {
        //setCorrectDir();
        move();
    }

    /**
     * Moves ghost in the direction given using the unit vectors of the direction
     */
    public void move() {
        pos.x += speed * dir.getX_dir();
        pos.y += speed * dir.getY_dir();
    }


    /**
     * Sets the correct direction based on where the target position is relative to the ghost's current position
     * If the target position is between -45 and 45 degrees relative to the 3 O'Clock position, then direction
     * should be EAST. If target position is between 45 and 135 degrees, then direction should be NORTH
     * Repeat for the other 2 directions
     */
    private void setCorrectDir() {
        Point target = getTargetPos();
        if (target.x == pos.x) {
            if (target.y >= pos.y)
                setDir(Direction.SOUTH);
            else
                setDir(Direction.NORTH);
        }

        else {
            double slope = ((double) (target.y - pos.y))/((double) (target.x - pos.x));

            if (target.x < pos.x) {
                if (slope > 1)
                    setDir(Direction.SOUTH);
                else if (slope < -1)
                    setDir(Direction.NORTH);
                else
                    setDir(Direction.WEST);
            }

            else {
                if (slope > 1)
                    setDir(Direction.NORTH);
                else if (slope < -1)
                    setDir(Direction.SOUTH);
                else
                    setDir(EAST);
            }
        }
    }

    // Get the target position for the Ghost. Each ghost has a unique target position
    protected abstract Point getTargetPos();
    // Gets the array of images for each class
    protected abstract ImageIcon[] getImages();

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
    public Point getPos() {return pos;}
    public ImageIcon getImage() {return image;}
    public double getSpeed() {return speed;}
    public Direction getDir() {return  dir;}
}
