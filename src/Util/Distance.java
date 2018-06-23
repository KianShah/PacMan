package Util;

import java.awt.*;

/*
 * Distance utility class for finding the distance between 2 points
 */
public class Distance {

    // Returns the distance between 2 points as a double
    public static double getDistance(Point p1, Point p2) {
        double c_squared = (p2.x - p1.x) / (p2.y - p1.y);
        return Math.sqrt(c_squared);
    }
}
