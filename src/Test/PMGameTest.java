package Test;

import Model.GhostAbstract;
import Model.PMGame;
import Model.PacMan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PMGameTest {
    PMGame game;
    PacMan pacMan;
    GhostAbstract[] ghosts;

    @BeforeEach
    public void runBefore() {
        game = PMGame.getInstance();
        pacMan = game.getPacMan();
        ghosts = game.getGhosts();
    }

    @Test
    public void testMove() {
        Point PacMan_Pos = new Point(pacMan.getPos().x, pacMan.getPos().y);
        Point Blinky_Pos = new Point(ghosts[0].getPos().x, ghosts[0].getPos().y);
        Point Inky_Pos = new Point(ghosts[1].getPos().x, ghosts[1].getPos().y);
        Point Pinky_Pos = new Point(ghosts[2].getPos().x, ghosts[2].getPos().y);
        Point Clyde_Pos = new Point(ghosts[3].getPos().x, ghosts[3].getPos().y);

        game.getPacMan().move();
        for (GhostAbstract ghost : ghosts)
            ghost.move();

        PacMan_Pos.x += pacMan.getSpeed();
        Blinky_Pos.x += ghosts[0].getSpeed();
        Inky_Pos.x += ghosts[1].getSpeed();
        Pinky_Pos.x += ghosts[2].getSpeed();
        Clyde_Pos.x += ghosts[3].getSpeed();

        assertEquals(PacMan_Pos, pacMan.getPos());
        assertEquals(Blinky_Pos, ghosts[0].getPos());
        assertEquals(Inky_Pos, ghosts[1].getPos());
        assertEquals(Pinky_Pos, ghosts[2].getPos());
        assertEquals(Clyde_Pos, ghosts[3].getPos());

    }
}
