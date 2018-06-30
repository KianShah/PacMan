package Model;

import Model.Ghosts.Blinky;
import Model.Ghosts.Clyde;
import Model.Ghosts.Inky;
import Model.Ghosts.Pinky;
import Util.Direction;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static java.awt.event.KeyEvent.*;

/*
 * Class representing the PacMan game
 * Implemented with Singleton design pattern
 * Note: This class is the subject of the Observer design pattern for the ghosts class
 */
public class PMGame {

    private PacMan pacMan;
    private GhostAbstract[] ghosts; // Note: If we want to expand the game during runtime for more ghosts, we need a List, not an Array
    private List<Star> stars;
    private int lives;

    private static PMGame instance;
    private boolean gameOver;

    private PMGame() {
        pacMan = PacMan.getInstance();
        ghosts = new GhostAbstract[] {new Blinky(), new Inky(), new Pinky(), new Clyde()};
        stars = new LinkedList<>();

        lives = 3;
        gameOver = false;

        addStars();
    }

    /**
     * Initializes the stars list with the required initial stars
     */
    private void addStars() {

    }

    public static PMGame getGame() {
        if (instance == null)
            instance = new PMGame();

        return instance;
    }

    /**
     * Updates all game objects and checks to see if game is over
     * EFFECTS: Moves PacMan and ghosts
     */
    public void update() {
        pacMan.move();
        updateGhosts();
        collisionHandler();
        checkIfGameOver();
    }

    /**
     * Helper function for update
     * EFFECT: Updates the positions and directions of each ghost in ghosts
     * Note that this is equivalent to the NotifyAllObservers method in the Observer design pattern
     */
    private void updateGhosts() {
        for (GhostAbstract ghost : ghosts)
            ghost.update();
    }

    /**
     * Helper function for update
     * Checks to see if there were any collisions between PacMan and Ghosts or PacMan and Stars
     */
    private void collisionHandler() {
        for (GhostAbstract ghost : ghosts) {
            if (ghostCollidedWithPM(ghost)) {
                lives--;
                gameReset();
            }
        }
    }

    /**
     * Helper function for collisionHandler
     * @param ghost The given ghost to check if has collided with PacMan
     * @return True if PacMan has collided with the given ghost and false otherwise
     */
    boolean ghostCollidedWithPM(GhostAbstract ghost) {
        Point PM_Pos = pacMan.getPos();
        Point GH_Pos = ghost.getPos();

        return (GH_Pos.x <= PM_Pos.x + 20 && GH_Pos.x >= PM_Pos.x - 20) &&
                (GH_Pos.y <= PM_Pos.y + 20 && GH_Pos.y >= PM_Pos.y - 20);
    }

    /**
     * Resets PacMan and Ghost objects to their initial positions
     * Used for when PacMan collides with a ghost
     */
    private void gameReset() {
        pacMan.setPos(PacMan.initialPos);
        pacMan.setDir(Direction.EAST);

        for (GhostAbstract ghost : ghosts) {
            ghost.setPos(ghost.getInitialPos());
            ghost.setDir(Direction.EAST);
        }
    }


    /**
     * Helper function for update
     * EFFECT: Updates the value of isGameOver to true if lives <= 0
     */
    private void checkIfGameOver() {
        gameOver = lives <= 0;
    }

    /**
     * Changes the direction that PacMan is facing based on the key pressed
     *
     * EFFECTS: PacMan direction changed to one of:
     *      North if up key is pressed
     *      East if right key is pressed
     *      South if down key is pressed
     *      West if left key is pressed
     *      Direction is unchanged otherwise
     */
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
    public List<Star> getStars() {return stars;}
    public boolean isGameOver() {return gameOver;}
}
