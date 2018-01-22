package Model;

import java.util.ArrayList;
import java.util.List;

public class PMGame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Ghost Blinky = new Ghost(GhostType.BLINKY, WIDTH/2, HEIGHT/4);
    private Ghost Pinky = new Ghost(GhostType.PINKY, WIDTH/2, HEIGHT/4);
    private Ghost Inky = new Ghost(GhostType.INKY, WIDTH/2, HEIGHT/4);
    private Ghost Clyde = new Ghost(GhostType.CLYDE, WIDTH/2, HEIGHT/4);

    private PacMan pacMan;
    private List<Ghost> ghosts;

    public PMGame() {
        pacMan = new PacMan(WIDTH/2, HEIGHT/2);
        ghosts = new ArrayList<>();

        setUp();
    }

    public void setUp() {
        ghosts.clear();
        ghosts.add(Blinky);
        ghosts.add(Pinky);
        ghosts.add(Inky);
        ghosts.add(Clyde);

        pacMan.setX(WIDTH/2);
        pacMan.setY(HEIGHT/2);
    }

    public void update() {
        movePacMan();
        moveGhosts();
        checkCollisions();
        isGameOver();
    }

    private  void movePacMan() {

    }

    private void moveGhosts() {
        for (Ghost next : ghosts) {
            moveGhost(next);
        }
    }

    private void moveGhost(Ghost ghost) {

    }

    private void checkCollisions() {

    }

    private void isGameOver() {

    }

}
