package UI;

import Model.Direction;
import Model.PacMan;

import static java.awt.event.KeyEvent.*;

public class PMGame {
    private PacMan pacMan;

    public PMGame() {
        pacMan = PacMan.getInstance();
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

}
