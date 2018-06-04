
package Util;

import java.awt.*;

public enum GhostType {
    BLINKY (Color.RED, 2, "Blinky"),
    PINKY (Color.PINK, 3, "Pinky"),
    INKY (Color.CYAN, 4, "Inky"),
    CLYDE (Color.ORANGE, 5, "Clyde");

    private final Color color;
    private final int speed;
    private final String name;

    GhostType(Color color, int speed, String name) {
        this.color = color;
        this.speed = speed;
        this.name = name;
    }

    // Getter methods
    public Color getColor() {
        return color;
    }
    public int getSpeed() {
        return speed;
    }
    public String getName() {
        return name;
    }

}
