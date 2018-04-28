package util;

public class Pos {

    private int x;
    private int y;

    public Pos(int x_pos, int y_pos) {
        x = x_pos;
        y = y_pos;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
