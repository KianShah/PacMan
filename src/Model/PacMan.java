package Model;

public class PacMan {
    private final int speed = 4;

    private int x;
    private int y;

    public PacMan(int x_pos, int y_pos) {
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
