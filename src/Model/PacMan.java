package Model;

import util.Pos;

import javax.swing.*;

/**
 * Represents a PacMan object
 */
public class PacMan {

    private int speed = 4;
    private Pos pos;
    private final ImageIcon image;

    // Initializes Pacman object
    public PacMan(Pos pos) {
        this.pos = pos;
        this.image = new ImageIcon("PacMan.png");
    }

    public Pos getPos() {
        return pos;
    }
    public void setPos(Pos pos) {
        this.pos = pos;
    }
    public int getSpeed() {
        return speed;
    }
    public ImageIcon getImage() {return image;}
}
