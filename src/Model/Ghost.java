package Model;

public class Ghost {
    private int x;
    private int y;
    private final GhostType type;

    public Ghost(GhostType type, int x_pos, int y_pos) {
        this.type = type;
        x = x_pos;
        y = y_pos;
    }

    public GhostType getType() {
        return type;
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
