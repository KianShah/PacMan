package Test;

import Model.GhostAbstract;
import Model.Ghosts.Blinky;
import Model.Ghosts.Clyde;
import Model.Ghosts.Inky;
import Model.Ghosts.Pinky;
import Model.PacMan;
import Util.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GhostsTest {
    GhostAbstract[] ghosts;

    @BeforeEach
    public void runBefore() {
        ghosts = new GhostAbstract[]{new Blinky(), new Inky(), new Pinky(), new Clyde()};
    }

    @Test
    public void testBlinky(){
        Blinky blinky = (Blinky) ghosts[0];
        assertEquals(blinky.getTargetPos(), PacMan.getInstance().getPos());
        assertEquals(blinky.getImage(), Blinky.BLINKY_EAST);
        assertEquals(blinky.getPos(), GhostAbstract.initialPos);
        assertEquals(blinky.getDir(), Direction.EAST);
        assertEquals(blinky.getSpeed(), Blinky.speed);
    }

    @Test
    public void testInky(){
        Inky inky = (Inky) ghosts[1];
        assertEquals(inky.getTargetPos(), PacMan.getInstance().getPos());
        assertEquals(inky.getImage(), Inky.INKY_EAST);
        assertEquals(inky.getPos(), GhostAbstract.initialPos);
        assertEquals(inky.getDir(), Direction.EAST);
        assertEquals(inky.getSpeed(), Inky.speed);
    }

    @Test
    public void testPinky(){
        Pinky pinky = (Pinky) ghosts[2];
        assertEquals(pinky.getTargetPos(), PacMan.getInstance().getPos());
        assertEquals(pinky.getImage(), Pinky.PINKY_EAST);
        assertEquals(pinky.getPos(), GhostAbstract.initialPos);
        assertEquals(pinky.getDir(), Direction.EAST);
        assertEquals(pinky.getSpeed(), Pinky.speed);
    }

    @Test
    public void testClyde(){
        Clyde clyde = (Clyde) ghosts[3];
        assertEquals(clyde.getTargetPos(), PacMan.getInstance().getPos());
        assertEquals(clyde.getImage(), Clyde.CLYDE_EAST);
        assertEquals(clyde.getPos(), GhostAbstract.initialPos);
        assertEquals(clyde.getDir(), Direction.EAST);
        assertEquals(clyde.getSpeed(), Clyde.speed);
    }

    @Test
    public void testGhostAbstract(){
        GhostAbstract ghost = ghosts[2];
        Point p = new Point(ghost.getPos().x, ghost.getPos().y);
        double speed = ghost.getSpeed();

        ghost.setDir(Direction.EAST);
        ghost.move();
        p.x += speed;
        assertEquals(p, ghost.getPos());

        ghost.setDir(Direction.NORTH);
        ghost.move();
        p.y -= speed;
        assertEquals(p, ghost.getPos());


    }
}
