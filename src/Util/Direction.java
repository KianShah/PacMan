package Util;

/*
 * A list of directions (N,S,E,W)
 * Each direction has 2 ints that represent the direction's corresponding 2D unit vectors
 * and an image of PacMan facing the corresponding direction
 *
 * NOTE: y increases downwards, so the NORTH unit vector is [0, -1] and SOUTH is [0, 1]
 */
public enum Direction {

    NORTH (0,-1, Vector.unit_vector_NORTH),
    EAST (1,0, Vector.unit_vector_EAST),
    SOUTH (0,1, Vector.unit_vector_SOUTH),
    WEST (-1,0, Vector.unit_vector_WEST);

    private final int x;
    private final int y;
    private final Vector unit_vector;

    Direction(int x_dir, int y_dir, Vector unit_vector) {
        x = x_dir;
        y = y_dir;
        this.unit_vector = unit_vector;
    }

    // Getter methods
    public int getX_dir() {
        return x;
    }
    public int getY_dir() {
        return y;
    }

    public Vector getUnit_vector() {
        return unit_vector;
    }
}
