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
 * Note: This class is the subject of the Observer design pattern for the ghosts class
 */
public class PMGame {

    private PacMan pacMan;
    private GhostAbstract[] ghosts; // Note: If we want to expand the game during runtime for more ghosts, we need a List, not an Array
    private int lives = 3;

    private static PMGame instance;
    private boolean gameOver;

    private PMGame() {
        pacMan = PacMan.getInstance();
        ghosts = new GhostAbstract[] {new Blinky(), new Inky(), new Pinky(), new Clyde()};
        gameOver = false;
    }

    public static PMGame getGame() {
        if (instance == null)
            instance = new PMGame();

        return instance;
    }

    // Updates all game objects and checks to see if game is over
    // EFFECTS: Moves PacMan and ghosts
    public void update() {
        pacMan.move();
        updateGhosts();
        checkIfGameOver();
    }

    // Helper function for update
    // EFFECT: Updates the positions and directions of each ghost in ghosts
    // Note that this is equivalent to the NotifyAllObservers method in the Observer design pattern
    private void updateGhosts() {
        for (GhostAbstract ghost : ghosts)
            ghost.update();
    }

    // Helper function for update
    // EFFECT: Updates the value of isGameOver to true if lives <= 0
    private void checkIfGameOver() {
        gameOver = lives <= 0;
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
    public PacMan getPacMan() {return PacMan.getInstance();}
    public GhostAbstract[] getGhosts() {return ghosts;}
    public boolean isGameOver() {return gameOver;}
}
