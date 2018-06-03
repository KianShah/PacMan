package UI;

import Model.Direction;
import Model.PacMan;

import static java.awt.event.KeyEvent.*;

/*
 * Class representing the PacMan game
 * Implemented with Singleton design pattern
 */
public class PMGame {

    private PacMan pacMan;
    private static PMGame instance;
    private boolean gameOver;

    private PMGame() {
        pacMan = PacMan.getInstance();
    }

    public static PMGame getGame() {
        if (instance == null)
            instance = new PMGame();

        return instance;
    }

    public void update() {
        pacMan.move();
    }

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
        }
    }

    public PacMan getPacMan() {return pacMan;}

}
