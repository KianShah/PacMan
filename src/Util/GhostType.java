
package Util;

import java.awt.*;

public enum GhostType {
    BLINKY (Color.RED, 2.5, "Blinky"),
    PINKY (Color.PINK, 3, "Pinky"),
    INKY (Color.CYAN, 3.5, "Inky"),
    CLYDE (Color.ORANGE, 4, "Clyde");

    private final Color color;
    private final double speed;
    private final String name;

    GhostType(Color color, double speed, String name) {
        this.color = color;
        this.speed = speed;
        this.name = name;
    }

    // Getter methods
    public Color getColor() {
        return color;
    }
    public double getSpeed() {
        return speed;
    }
    public String getName() {
        return name;
    }

}
