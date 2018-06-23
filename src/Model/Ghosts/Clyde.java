package Model.Ghosts;

import Model.GhostAbstract;
import Model.PacMan;
import Util.Direction;

import javax.swing.*;
import java.awt.*;

public class Clyde extends GhostAbstract {
    public static final double speed = 5.0;

    public static final ImageIcon CLYDE_EAST = new ImageIcon("Images/Clyde Images/ClydeEAST.png");
    public static final ImageIcon CLYDE_SOUTH = new ImageIcon("Images/Clyde Images/ClydeSOUTH.png");
    public static final ImageIcon CLYDE_WEST = new ImageIcon("Images/Clyde Images/ClydeWEST.png");
    public static final ImageIcon CLYDE_NORTH = new ImageIcon("Images/Clyde Images/ClydeNORTH.png");

    public final ImageIcon[] images = {CLYDE_EAST, CLYDE_SOUTH, CLYDE_WEST, CLYDE_NORTH};

    public Clyde(int speed, Point pos, ImageIcon image, Direction dir) {
        super(speed, pos, image, dir);
    }

    public Clyde() {
        super(speed, GhostAbstract.initialPos, CLYDE_EAST, Direction.EAST);
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
