package Test;

import Model.PacMan;
import Util.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacManTest {
    private PacMan pacMan;

    @BeforeEach
    public void runBefore() {
        pacMan = PacMan.getInstance();
    }

    // General test for testing all methods that need to be tested
    // Note that we are unable to test different methods in different tests due to dependencies that exist
    // between different tests (Mainly that there is only 1 Pacman so any changes made to the PacMan in one test
    // will influence the other tests)
    @Test
    public void test() {
        assertEquals(PacMan.initialPos, pacMan.getPos());
        assertEquals(Direction.EAST, pacMan.getDir());
        assertEquals(PacMan.PM_EAST, pacMan.getImage());
        assertEquals(3.0, pacMan.getSpeed());

        pacMan.setDir(Direction.WEST);  // Set Direction test
        assertEquals(Direction.WEST, pacMan.getDir());
        assertEquals(PacMan.PM_WEST, pacMan.getImage());
        pacMan.setDir(Direction.SOUTH);
        assertEquals(Direction.SOUTH, pacMan.getDir());
        assertEquals(PacMan.PM_SOUTH, pacMan.getImage());
        pacMan.setDir(Direction.EAST);
        assertEquals(Direction.EAST, pacMan.getDir());
        assertEquals(PacMan.PM_EAST, pacMan.getImage());
        pacMan.setDir(Direction.NORTH);
        assertEquals(Direction.NORTH, pacMan.getDir());
        assertEquals(PacMan.PM_NORTH, pacMan.getImage());
    }

    @Test
    public void testSetDir() {

    }
}