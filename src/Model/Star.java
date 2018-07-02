package Model;

import Util.ImageBuffer;

import java.awt.*;

/**
 * Represents the food object that PacMan must eat
 */
public class Star {
    public Point pos;

    public static final int margin = 20; // Represents the space between stars on the map
    public static final Image image = ImageBuffer.getImage("/Model/star.png", Star.class);

    public Star(Point pos) {
        this.pos = pos;
    }

    public Star(int x, int y) {
        pos = new Point(x,y);
    }
}
