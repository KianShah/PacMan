package Util;

import java.awt.*;

public class Vector {
    public int x;
    public int y;

    public static final Vector unit_vector_NORTH = new Vector(0,-1);
    public static final Vector unit_vector_EAST = new Vector(1,0);
    public static final Vector unit_vector_SOUTH = new Vector(0,1);
    public static final Vector unit_vector_WEST = new Vector(-1,0);

    public Vector() {
        x = 0;
        y = 0;
    }

    public Vector (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    public Vector multiply(int multiplier) {
        return new Vector(this.x * multiplier, this.y * multiplier);
    }

    public Point toPoint() { return new Point(x, y);}

    public static Vector toVector(Point X) {
        return new Vector(X.x, X.y);
    }

    public int getDotProduct(Vector other) {
        return this.x * other.x + this.y * other.y;
    }

    public double getMagnitude() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public double getCos(Vector other) {
        return this.getDotProduct(other) / (this.getMagnitude() * other.getMagnitude());
    }

    public double getAngle(Vector other) {
        return Math.acos(this.getCos(other));
    }
}
