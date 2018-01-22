package Model;

import java.awt.*;

public enum GhostType {
    BLINKY (Color.RED, 2),
    PINKY (Color.PINK, 3),
    INKY (Color.CYAN, 4),
    CLYDE (Color.ORANGE, 5);

    private final Color color;
    private final int speed;

    GhostType(Color color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
}
