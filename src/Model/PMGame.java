package Model;

import Model.Ghosts.Blinky;
import Model.Ghosts.Clyde;
import Model.Ghosts.Inky;
import Model.Ghosts.Pinky;
import UI.PacManGame;
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

    private int points;
    private int lives;

    private static PMGame instance;

    private boolean gameOver;
    private boolean gameWon;

    private PMGame() {
        pacMan = PacMan.getInstance();
        ghosts = new GhostAbstract[] {new Blinky(), new Inky(), new Pinky(), new Clyde()};
        stars = new LinkedList<>();

        points = 0;
        lives = 3;

        gameWon = false;
        gameOver = false;

        addStars();
    }

    public static PMGame getInstance() {
        if (instance == null)
            instance = new PMGame();

        return instance;
    }

    /**
     * Initializes the stars list with the required initial stars
     */
    private void addStars() {
        for (int y = 100; y + 200 < PacManGame.FRAME_HEIGHT; y += 200)
            for (int x = 100; x + 200 < PacManGame.FRAME_WIDTH; x += 200)
                stars.add(new Star(x,y));
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
        checkIfGameWon();
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
                points -= 100;
                gameReset();
            }
        }

        // Assume that PacMan can only collide with one star at a time
        int starToBeRemoved = -1;

        for (int i = 0; i < stars.size(); ++i) {
            if (starCollidedWithPM(stars.get(i))) {
                points += 20;
                starToBeRemoved = i;
            }
        }

        if (starToBeRemoved != -1)
            stars.remove(starToBeRemoved);


    }

    /**
     * Helper function for collisionHandler
     * @param ghost The given ghost to check if has collided with PacMan
     * @return True if PacMan has collided with the given ghost and false otherwise
     */
    private boolean ghostCollidedWithPM(GhostAbstract ghost) {
        Point PM_Pos = pacMan.getPos();
        Point GH_Pos = ghost.getPos();

        return (GH_Pos.x <= PM_Pos.x + 35 && GH_Pos.x >= PM_Pos.x - 35) &&
                (GH_Pos.y <= PM_Pos.y + 35 && GH_Pos.y >= PM_Pos.y - 35);
    }

    /**
     * Helper function for collisionHandler
     * @param star The given star to check if has collided with PacMan
     * @return true if PacMan has collided with the given star and false otherwise
     */
    private boolean starCollidedWithPM(Star star) {
        Point PM_Pos = pacMan.getPos();
        Point ST_Pos = star.pos;

        return (ST_Pos.x <= PM_Pos.x + 30 && ST_Pos.x >= PM_Pos.x - 30) &&
                (ST_Pos.y <= PM_Pos.y + 30 && ST_Pos.y >= PM_Pos.y - 30);
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
     * EFFECT: Updates the value of gameOver to true if lives <= 0
     */
    private void checkIfGameOver() {
        gameOver = lives <= 0;
    }

    /**
     * Helper function for update
     * EFFECT: Updates the value of gameWon to true if stars is empty
     */
    private void checkIfGameWon() {
        gameWon = stars.isEmpty();
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

    public int getPoints() {return points;}
    public int getLives() {return lives;}

    public boolean isGameWon() {return gameWon;}
    public boolean isGameOver() {return gameOver;}
}
