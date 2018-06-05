package Model;

import Util.GhostType;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public abstract class GhostAbstract {
    private GhostType type;
    private ImageIcon image;
    private double speed;
    private Point pos;
    private Direction dir;

    protected GhostAbstract(GhostType type, Point pos, ImageIcon image, Direction dir) {
        this.type = type;
        this.pos = pos;
        this.image = image;
        this.dir = dir;
        this.speed = type.getSpeed();
    }

    public void move() {
        pos.x += speed * dir.getX_dir();
        pos.y += speed * dir.getY_dir();
    }

    // Getter methods
    public GhostType getType() {
        return type;
    }
    public Point getPos() {
        return pos;
    }
    public ImageIcon getImage() {return image;}
    public double getSpeed() {return speed;}
    public Direction getDir() {return  dir;}


    // Setter methods
    protected void setDir(Direction dir) {this.dir = dir;}
    protected void setImage(ImageIcon image) {this.image = image;}
}
