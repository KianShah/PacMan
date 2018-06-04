package Model;

import java.awt.*;

public abstract class GhostAbstract {
    protected GhostType type;
    protected Point pos;

    protected GhostAbstract(GhostType type, Point pos) {
        this.type = type;
        this.pos = pos;
    }

    protected abstract GhostAbstract getInstance();

    protected GhostType getType() {
        return type;
    }
    protected Point getPos() {
        return pos;
    }
    protected void setPos(Point pos) {
        this.pos = pos;
    }
}
