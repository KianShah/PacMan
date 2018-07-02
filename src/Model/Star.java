package Model;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the food object that PacMan must eat
 */
public class Star {
    public Point pos;

    public static final int margin = 20; // Represents the space between stars on the map
    public static final ImageIcon image = new ImageIcon("src/Images/star.png");

    public Star(Point pos) {
        this.pos = pos;
    }

    public Star(int x, int y) {
        pos = new Point(x,y);
    }
}
