package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Inky extends GhostAbstract {
    public static final Point initialPos = new Point(50,50);
    public static final double speed = 2.0;

    public static final ImageIcon INKY_EAST = new ImageIcon("Images/Inky Images/InkyEAST.png");
    public static final ImageIcon INKY_SOUTH = new ImageIcon("Images/Inky Images/InkySOUTH.png");
    public static final ImageIcon INKY_WEST = new ImageIcon("Images/Inky Images/InkyWEST.png");
    public static final ImageIcon INKY_NORTH = new ImageIcon("Images/Inky Images/InkyNORTH.png");

    private final ImageIcon[] images = {INKY_EAST, INKY_SOUTH, INKY_WEST, INKY_NORTH};

    public Inky(int speed, Point pos, ImageIcon image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Inky() {
        super(speed, initialPos, INKY_EAST, Direction.EAST);
    }

    @Override
    public Point getTargetPos() {
        return PacMan.getInstance().getPos();
    }

    @Override
    protected ImageIcon[] getImages() {
        return images;
    }
}
