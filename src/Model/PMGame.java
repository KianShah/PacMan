package Model;

import Model.Ghosts.Blinky;
import Model.Ghosts.Clyde;
import Model.Ghosts.Inky;
import Model.Ghosts.Pinky;
import Util.Direction;

import static java.awt.event.KeyEvent.*;

/*
 * Class representing the PacMan game
 * Implemented with Singleton design pattern
 */
public class PMGame {

    private PacMan pacMan;
    private Blinky blinky;
    private Inky inky;
    private Pinky pinky;
    private Clyde clyde;
    private GhostAbstract[] ghosts;

    private static PMGame instance;
    private boolean gameOver;

    private PMGame() {
        pacMan = PacMan.getInstance();
        blinky = new Blinky();
        inky = new Inky();
        pinky = new Pinky();
        clyde = new Clyde();

        ghosts = new GhostAbstract[4];
        ghosts[0] = blinky;
        ghosts[1] = inky;
        ghosts[2] = pinky;
        ghosts[3] = clyde;

        gameOver = false;
    }

    public static PMGame getGame() {
        if (instance == null)
            instance = new PMGame();

        return instance;
    }

    // Updates game
    // EFFECTS: Moves PacMan and ghosts
    public void update() {
        pacMan.move();

        for (GhostAbstract ghost : ghosts)
            ghost.move();
    }

    // Changes the direction that PacMan is facing based on the key pressed
    // EFFECTS: PacMan direction changed to one of:
    // North if up key is pressed
    // East if right key is pressed
    // South if down key is pressed
    // West if left key is pressed
    // Direction is unchanged otherwise
    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case VK_LEFT:
                pacMan.setDir(Direction.WEST);
                break;

            case VK_UP:
                pacMan.setDir(Direction.NORTH);
                break;

            case VK_RIGHT:
                pacMan.setDir(Direction.EAST);
                break;

            case VK_DOWN:
                pacMan.setDir(Direction.SOUTH);
                break;

            default: // do nothing
        }
    }

    // Getter methods
    public PacMan getPacMan() {return pacMan;}
    public Blinky getBlinky() {
        return blinky;
    }
    public Inky getInky() {
        return inky;
    }
    public Pinky getPinky() {
        return pinky;
    }
    public Clyde getClyde() {
        return clyde;
    }
    public GhostAbstract[] getGhosts() {return ghosts;}
    public boolean isGameOver() {return gameOver;}
}
