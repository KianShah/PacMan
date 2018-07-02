package Model;

import Util.Direction;

import java.awt.*;

import static Util.Direction.*;

/*
 * Abstract ghost class to implement our observer design pattern
 */
public abstract class GhostAbstract extends MoveableSprite{
    private final Point initialPos;

    // GhostAbstract Constructor
    // Note that the value of initialPos is set to the first value that we set for pos
    // INVARIANT: All calls to a Ghost's constructor must be made with the ghost's static initial position
    // passed in the constructor
    protected GhostAbstract(int speed, Point pos, Image image, Direction dir) {
        super(speed, pos, image, dir);
        initialPos = new Point(pos.x, pos.y);
    }

    /**
     *  Updates the ghost's direction and position
     */
    public void update() {
        setCorrectDir();
        move();
    }

    /**
     * Sets the correct direction based on where the target position is relative to the ghost's current position
     * If the target position is between -45 and 45 degrees relative to the 3 O'Clock position, then direction
     * should be EAST. If target position is between 45 and 135 degrees, then direction should be NORTH
     * Repeat for the other 2 directions
     */
    private void setCorrectDir() {
        Point target = getTargetPos();
        if (target.x == getPos().x) {    // If slope is undefined
            if (target.y >= getPos().y)      // If target is AT or BELOW current pos
                setDir(SOUTH);
            else                        // If target is ABOVE current pos
                setDir(NORTH);
        }

        else {                      // Else slope is defined
            double slope = -((double) (target.y - getPos().y))/((double) (target.x - getPos().x)); // Note that slope is made neg
                                                                                                   // since y increases downwards
            if (target.x < getPos().x) {     // If target pos is to the LEFT of current POS
                if (slope > 1)              // If target pos is below the 45 deg line
                    setDir(SOUTH);
                else if (slope < -1)
                    setDir(NORTH);
                else
                    setDir(WEST);
            } else {
                if (slope > 1)
                    setDir(NORTH);
                else if (slope < -1)
                    setDir(SOUTH);
                else
                    setDir(EAST);
            }
        }
    }

    public Point getInitialPos() {
        return initialPos;
    }

    // Get the target position for the Ghost. Each ghost has a unique target position
    public abstract Point getTargetPos();
}
