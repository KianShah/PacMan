package Util;

/*
 * A list of directions (N,S,E,W)
 * Each direction has 2 ints that represent the direction's corresponding 2D unit vectors
 * and an image of PacMan facing the corresponding direction
 *
 * NOTE: y increases downwards, so the NORTH unit vector is [0, -1] and SOUTH is [0, 1]
 */
public enum Direction {

    NORTH (0,-1),
    EAST (1,0),
    SOUTH (0,1),
    WEST (-1,0);

    private final int x;
    private final int y;

    Direction(int x_dir, int y_dir) {
        x = x_dir;
        y = y_dir;
    }

    // Getter methods
    public int getX_dir() {
        return x;
    }
    public int getY_dir() {
        return y;
    }
}
