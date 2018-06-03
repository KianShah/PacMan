package Model;

import javax.swing.*;

/*
 * A list of directions (N,S,E,W)
 * Each direction has 2 ints that represent the direction's corresponding 2D unit vectors
 * and an image of PacMan facing the corresponding direction
 * NOTE: y increases downwards
 */
public enum Direction {

    NORTH (0,-1, PacMan.PM_NORTH),
    EAST (1,0, PacMan.PM_EAST),
    SOUTH (0,1, PacMan.PM_SOUTH),
    WEST (-1,0, PacMan.PM_WEST);

    private int x_dir;
    private int y_dir;
    private ImageIcon PMimage;

    Direction(int x_dir, int y_dir, ImageIcon icon) {
        this.x_dir = x_dir;
        this.y_dir = y_dir;
        this.PMimage = icon;
    }

    // Getter methods
    public int getX_dir() {
        return x_dir;
    }
    public int getY_dir() {return y_dir;}
    public ImageIcon getImage() {return PMimage;}
}
