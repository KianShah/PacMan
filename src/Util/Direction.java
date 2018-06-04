package Util;

/*
 * A list of directions (N,S,E,W)
 * Each direction has 2 ints that represent the direction's corresponding 2D unit vectors
 * and an image of PacMan facing the corresponding direction
 * NOTE: y increases downwards
 */
public enum Direction {

    NORTH (0,-1),
    EAST (1,0),
    SOUTH (0,1),
    WEST (-1,0);

    private int x_dir;
    private int y_dir;

    Direction(int x_dir, int y_dir) {
        this.x_dir = x_dir;
        this.y_dir = y_dir;
    }

    // Getter methods
    public int getX_dir() {
        return x_dir;
    }
    public int getY_dir() {return y_dir;}
}
