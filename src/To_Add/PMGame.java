//package To_Add;
//
//import Model.PacMan;
//import To_Add.Ghost;
//import To_Add.GhostType;
//import util.Pos;
//
//import java.awt.event.KeyEvent;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PMGame {
//    public static final int WIDTH = 800;
//    public static final int HEIGHT = 600;
//
//    private PacMan pacMan;
//    private List<Ghost> ghosts;
//
//     * Ghosts list initialized, # of lives initialized, PacMan initialized
//     *//*
//
//    public PMGame() {
//        pacMan = new PacMan(new Pos(WIDTH/2, HEIGHT/2));
//
//        Blinky = new Ghost(GhostType.BLINKY, new Pos(WIDTH/2, HEIGHT/4));
//        Pinky = new Ghost(GhostType.PINKY, new Pos(WIDTH/2, HEIGHT/4));
//        Inky = new Ghost(GhostType.INKY, new Pos(WIDTH/2, HEIGHT/4));
//        Clyde = new Ghost(GhostType.CLYDE, new Pos(WIDTH/2, HEIGHT/4));
//
//        ghosts = new ArrayList<>();
//        ghosts.add(Blinky);
//        ghosts.add(Pinky);
//        ghosts.add(Inky);
//        ghosts.add(Clyde);
//
//        lives = 3;
//
//        newGame();
//    }
//
//
//    public void newGame() {
//        for (Ghost next : ghosts) {
//            next.setPos(new Pos(WIDTH/2, HEIGHT/2));
//        }
//
//        ;
//    }
//
//    public void update() {
//        movePacMan();
//        moveGhosts();
//        checkCollisions();
//        isGameOver();
//    }
//
//    private  void movePacMan(int key) {
//        int PacMan_X = pacMan.getPos().getX();
//        int PacMan_Y = pacMan.getPos().getY();
//
//        switch (key) {
//            case KeyEvent.VK_LEFT: pacMan.setPos(new Pos(PacMan_X - pacMan.getSpeed(), PacMan_Y));
//                                    break;
//            case KeyEvent.VK_RIGHT: pacMan.setPos(new Pos(PacMan_X + pacMan.getSpeed(), PacMan_Y));
//                break;
//            case KeyEvent.VK_UP: pacMan.setPos(new Pos(PacMan_X , PacMan_Y - pacMan.getSpeed()));
//                break;
//            case KeyEvent.VK_DOWN: pacMan.setPos(new Pos(PacMan_X , PacMan_Y + pacMan.getSpeed()));
//                break;
//            default: pacMan.setPos(pacMan.getPos());
//        }
//    }
//
//    private void moveGhosts() {
//        for (Ghost next : ghosts) {
//            moveGhost(next);
//        }
//    }
//
//    private void moveGhost(Ghost ghost) {
//
//    }
//
//    private void checkCollisions() {
//        for (Ghost next : ghosts) {
//            if (pacMan.getPos() == next.getPos()) {
//                lives -= 1;
//                newGame();
//            }
//        }
//    }
//
//    private boolean isGameOver() {
//        return lives == 0;
//    }
//
//}
